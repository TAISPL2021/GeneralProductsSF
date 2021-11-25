import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import {Carrito} from '../../../core/entity/carrito.model';
import {Order} from '../../../core/entity/order.model';
import {CartService} from './../../../core/services/cart/cart.service';
import {FormBuilder, FormGroup, Validator, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {OrderService} from './../../../core/services/order/order.service';
import { CookieCart } from 'src/app/shared/crosscuting/CookieCart';
import { FacturaResponse } from 'src/app/core/entity/FacturaResponse.model';
import { MatStepper } from '@angular/material/stepper';
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
  factura: FacturaResponse = {
    id: 0,
    facturaCodigo: 0,
    facturaFecha: "",
    facturaNombreCliente: "",
    facturaCorreoCliente: "",
    facturaDireccionCliente: "",
    productos: [
      {
        productoCode: 0,
        productoNombre: "",
        productoDetalle: "",
        productoPrecio: 0,
        productoCantidad: 0,
        total: 0
      }
        
    ],
    facturaTotal: 0
};
  carrito: Carrito[];
  displayedColumns: string[] = ['producto_id', 'producto_nombre', 'producto_cantidad'];
  displayedColumnsFactura: string[] = ['productoCode', 'productoNombre', 'productoCantidad', 'total'];

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
  goBill(stepper: MatStepper): void{
      stepper.next();
  }
  SavePago($event): any{
    event.preventDefault();
    if (this.form.valid){
      var idcarrito = this.carrito[0].id;
      const order : Order = this.form.value;
      order.userName = this.cookieCart.getCookieUser();
      console.log(order);
      this.orderService.BuyNow(order,idcarrito).subscribe( (facturaresponse) => {
        console.log(facturaresponse);
        this.factura = facturaresponse;
        alert('Pago creado!');
        this.cookieCart.destroyCart();
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
