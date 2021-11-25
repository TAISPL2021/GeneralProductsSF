import { Injectable } from '@angular/core';
import { CookieService } from "ngx-cookie-service";
import { Carrito } from 'src/app/core/entity/carrito.model';

@Injectable({
    providedIn: 'root'
})
export class CookieCart {

    constructor(private cookieService: CookieService) { }
    
    addCookie(cart: Carrito): Boolean{
        var ArrCart : Carrito[]= [];
        var index = -1;
        const cookieExists: boolean = this.cookieService.check('cart');
        if(cookieExists){
            var cartJson = this.cookieService.get('cart'); 
            console.log(cartJson)
            ArrCart = JSON.parse(cartJson);
            var index = ArrCart.findIndex(i => i.id == 0);
            if(index != -1){
                ArrCart[index].id = cart.id;
                index = -1;
            }

            index = ArrCart.findIndex(i => i.producto_id == cart.producto_id);
            if(index != -1){
                ArrCart[index].producto_cantidad += 1;
                index = -1;
            }
            else{
                ArrCart[ArrCart.length] = cart;
                index = -1;
            }
            
            cartJson=JSON.stringify(ArrCart);
            console.log(cartJson)
            this.cookieService.deleteAll('/', 'cart');     
            this.cookieService.delete('cart','/'); 
            this.cookieService.set("cart", cartJson);  
        }
        else{
            ArrCart[0]=cart;
            cartJson=JSON.stringify(ArrCart);
            console.log(cartJson);
            this.cookieService.set("cart", cartJson);  
        }
        return true;
    }

    getCookieCart(): Carrito[]{
        console.log("entro cookie");
        const cookieExists: boolean = this.cookieService.check('cart');
        console.log(cookieExists);
        if(cookieExists){
            var cartJson = this.cookieService.get('cart'); 
            var cartObj = JSON.parse(cartJson);
            console.log(cartJson);
            console.log(cartObj);
            return cartObj
        }
        return null;
    }

    getCookieUser(): string{
        console.log("entro cookie");
        const cookieExists: boolean = this.cookieService.check('userName');
        console.log(cookieExists);
        if(cookieExists){
            return this.cookieService.get('userName'); 
        }
        return "";
    }

    destroyCart(): void{
        const cookieExists: boolean = this.cookieService.check('cart');
        if(cookieExists){
            this.cookieService.deleteAll('/', 'cart');     
            this.cookieService.delete('cart','/'); 
        }
    }
}
  