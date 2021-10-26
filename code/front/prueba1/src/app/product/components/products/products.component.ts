import { JsonpClientBackend } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {Product} from '../../../core/entity/product.model';
import {ProductosService} from './../../../core/services/products/productos.service';
import {environment} from '../../../../environments/environment';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  productsMock: Product[] =[
    {
      id : "1",
      title : "sandwiches",
      price : 20000,
      description : "delicioso",
      image : "https://ichef.bbci.co.uk/news/800/cpsprodpb/125FC/production/_103206257_sandwich.png",
      stock: 10,
      discount: 20,
      state: true
    },
    {
      id : "2",
      title : "sandwiches2",
      price : 10000,
      description : "horribles",
      image : "https://ichef.bbci.co.uk/news/800/cpsprodpb/125FC/production/_103206257_sandwich.png",
      stock: 10,
      discount: 20,
      state: true
    }
  ];
  programacion: any;
  version: string;
  products: Product[] ;

  constructor(private productsService: ProductosService) { 
    this.programacion = environment.programacion;
    this.version = environment.Version;
  }

  ngOnInit(): void {
    this.fetchProducts();
  }
  clickProduct(id: number): any{
    console.log(id.toString());
  }

  fetchProducts(): any{
    this.products = this.productsMock;
    this.productsService.getAllProduct("").subscribe(products => {
      this.products = products;
      console.log(JSON.stringify(this.products));
    });
  }

  filterProduct(productTittle: string): any{
    this.fetchProducts();
    this.products = this.products.filter(element => element.title.includes(productTittle) == true);
  }

}
