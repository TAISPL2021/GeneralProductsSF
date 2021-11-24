import { Injectable } from '@angular/core';
import { CookieService } from "ngx-cookie-service";

@Injectable({
    providedIn: 'root'
})
export class CookieCart {

    constructor(private cookieService: CookieService) { }

    addCookie(cart: any): Boolean{
        const cookieExists: boolean = this.cookieService.check('cart');
        if(cookieExists){
            var cartJson = this.cookieService.get('cart'); 
            var cartObj = JSON.parse(cartJson);
            cartObj[cartObj.length+1] = cart;
            cartJson=JSON.stringify(cartObj);
            this.cookieService.deleteAll('/', 'cart');     
            this.cookieService.delete('cart','/'); 
            this.cookieService.set("cart", cartJson);  
        }
        else{
            cartJson=JSON.stringify(cart);
            this.cookieService.set("cart", cartJson);  
        }
        return true;
    }
}
  