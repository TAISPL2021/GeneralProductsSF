import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import {Carrito} from '../../../core/entity/carrito.model';
import {CartService} from './../../../core/services/cart/cart.service';
import {FormBuilder, FormGroup, Validator, Validators} from '@angular/forms';
import {Router} from '@angular/router';
@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {

  products$: Observable<Carrito[]>;
  hide = true;
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private cartService: CartService, private router: Router
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

  }
  
  getErrorMessage(): any{
    return "Campo obligatorio"
  }

}
