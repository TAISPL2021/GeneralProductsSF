import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ProductosService} from './services/products/productos.service';
import {PromotionService} from './services/promotion/promotion.service';
import {RegisterService} from './services/register/register.service';

@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule
  ],
  providers : [
    ProductosService,
    PromotionService,
    RegisterService
  ]
})
export class CoreModule { }
