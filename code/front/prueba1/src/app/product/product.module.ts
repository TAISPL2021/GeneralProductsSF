import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ProductsComponent } from './components/products/products.component';
import { ProductDetailComponent } from './components/product-detail/product-detail.component';
import { ProductComponent } from './components/product/product.component';
import {ProductRoutingModule} from './product-routing.module';
import {SharedModule} from './../shared/shared.module';
import {MaterialModule} from './../material/material.module';
import { FilterProductComponent } from './components/filter-product/filter-product.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    ProductsComponent,
    ProductDetailComponent,
    ProductComponent,
    FilterProductComponent
  ],
  exports: [
    ProductsComponent,
    ProductDetailComponent,
    ProductComponent,
    FilterProductComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    ProductRoutingModule,
    SharedModule,
    MaterialModule,
    FormsModule
  ]
})
export class ProductModule { }
