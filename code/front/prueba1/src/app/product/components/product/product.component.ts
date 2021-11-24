import {Component, Input, Output, EventEmitter} from '@angular/core';
import {Product} from '../../../core/entity/product.model';
import {CartService} from './../../../core/services/cart/cart.service'
import {environment} from '../../../../environments/environment';
import {Carrito} from '../../../core/entity/carrito.model';
import { CookieService } from 'ngx-cookie-service';
import {CookieCart} from '../../../shared/crosscuting/CookieCart';
@Component({
    selector : 'app-product',
    templateUrl : './product.component.html',
    styleUrls: ['./product.component.scss']
})
export class ProductComponent
{
    @Input() product: Product;
    @Output() productClicked: EventEmitter<any> = new EventEmitter();
    today = new Date();
    programacion: any;
    version: string;

    constructor(private cartService: CartService, private cookieCart: CookieCart )
    {
        this.programacion = environment.programacion;
        this.version = environment.Version;
    }
    addCart(): any{

        var carrito: Carrito ={
            id : 0,
            producto_id : this.product.id,
            producto_nombre : this.product.title,
            producto_detalle : this.product.description,
            producto_cantidad : 1,
        }
        
        this.cartService.addCart(carrito).subscribe(cart =>
        {
            console.log();
            carrito.id = cart.id;
            carrito = cart;
            this.cookieCart.addCookie(carrito);                
        });
        
        /*this.productClicked.emit(this.product.id);*/
    }

    
}
