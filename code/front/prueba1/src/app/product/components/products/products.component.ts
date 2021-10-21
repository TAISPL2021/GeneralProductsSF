import { JsonpClientBackend } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {Product} from '../../../core/entity/product.model';
import {ProductosService} from './../../../core/services/products/productos.service';
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  products: Product[] ;

  constructor(private productsService: ProductosService) {  }

  ngOnInit(): void {
    this.fetchProducts();
  }
  clickProduct(id: number): any{
    console.log(id.toString());
  }

  fetchProducts(): any{
    this.productsService.getAllProduct("").subscribe(products => {
      this.products = products;
      console.log(JSON.stringify(this.products));
    });
  }

}
