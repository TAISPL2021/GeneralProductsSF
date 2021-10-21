import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProductosService} from './services/products/productos.service';

@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule
  ],
  providers : [
    ProductosService,
  ]
})
export class CoreModule { }
