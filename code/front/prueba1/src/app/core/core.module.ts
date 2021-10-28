import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProductosService} from './services/products/productos.service';
import {RegisterService} from './services/register/register.service';

@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule
  ],
  providers : [
    ProductosService,
    RegisterService
  ]
})
export class CoreModule { }
