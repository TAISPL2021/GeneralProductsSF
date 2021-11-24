import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import {Carrito} from '../../../core/entity/carrito.model';
import {Order} from '../../../core/entity/order.model';
import {CartService} from './../../../core/services/cart/cart.service';
import {FormBuilder, FormGroup, Validator, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {OrderService} from './../../../core/services/order/order.service';
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


  constructor(
    private formBuilder: FormBuilder,
    private cartService: CartService, 
    private router: Router,
    private orderService: OrderService, 
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
  }

  SavePago($event): any{
    event.preventDefault();
    if (this.form.valid){
      const order = this.form.value;
      this.orderService.BuyNow(order).subscribe( (neworder) => {
        console.log(neworder);
        alert('Pago creado!');
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
