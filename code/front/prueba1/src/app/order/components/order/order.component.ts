import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import {Carrito} from '../../../core/entity/carrito.model';
import {Order} from '../../../core/entity/order.model';
import {CartService} from './../../../core/services/cart/cart.service';
import {FormBuilder, FormGroup, Validator, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {OrderService} from './../../../core/services/order/order.service';
import { CookieCart } from 'src/app/shared/crosscuting/CookieCart';
@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {

  products$: Observable<Carrito[]>;
  hide = true;
  form: FormGroup;
  order: Order;
  carrito: Carrito[];
  displayedColumns: string[] = ['producto_id', 'producto_nombre', 'producto_cantidad'];

  constructor(
    private formBuilder: FormBuilder,
    private cartService: CartService, 
    private router: Router,
    private orderService: OrderService, 
    private cookieCart: CookieCart
  )
  {
    this.products$ = this.cartService.cart$;
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        numeroTarjeta: ['', [Validators.required,Validators.pattern('[0-9]{15,16}|(([0-9]{4}\s){3}[0-9]{3,4})')]],
        NombreTarjeta: ['', [Validators.required,Validators.pattern('[a-zA-Z \s]*')]], 
        FechaExpiracion:['', [Validators.required,Validators.pattern('[0-9\/]*')]],
        NumeroDeVerificacion:['', [Validators.required,Validators.pattern('[0-9]{3}')]],
        cuotas: ['', [Validators.required]]
      }
    );
    this.carrito = this.cookieCart.getCookieCart();
    console.log(this.carrito);
    
  }

  SavePago($event): any{
    event.preventDefault();
    if (this.form.valid){
      var idcarrito = this.carrito[0].id;
      const order : Order = this.form.value;
      order.userName = this.cookieCart.getCookieUser();
      console.log(order);
      this.orderService.BuyNow(order,idcarrito).subscribe( (neworder) => {
        console.log(neworder);
        alert('Pago creado!');
        this.cookieCart.destroyCart();
        this.router.navigate(['/product']);
      });
    }
    else{
      alert('datos invalidos');
    } 
  }
  
  getErrorMessage(): any{
    return "Campo obligatorio"
  }

}
