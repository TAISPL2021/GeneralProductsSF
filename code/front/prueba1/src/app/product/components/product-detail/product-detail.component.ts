import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import {ProductosService} from './../../../core/services/products/productos.service';
import {Product} from '../../../core/entity/product.model';
import {CartService} from './../../../core/services/cart/cart.service'
import {environment} from '../../../../environments/environment';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {

  product: Product;
  programacion: any;
  version: string;
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

  constructor(private route: ActivatedRoute, private productsService: ProductosService, private cartService: CartService) { 
    this.programacion = environment.programacion;
    this.version = environment.Version;
  }
  
  ngOnInit(): void {
    this.product = this.productsMock[0];
    /*this.route.params.subscribe((params: Params) => {
      const id = params.id;
      this.productsService.(id).subscribe(product => {
        this.product = product;
      });
    });*/
  }

  addCart(): any{
    this.cartService.addCart(this.product);    
    /*this.productClicked.emit(this.product.id);*/
  }

}
