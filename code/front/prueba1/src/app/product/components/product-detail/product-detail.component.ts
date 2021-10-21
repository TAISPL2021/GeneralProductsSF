import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import {ProductosService} from './../../../core/services/products/productos.service';
import {Product} from '../../../core/entity/product.model';
import {CartService} from './../../../core/services/cart/cart.service'
@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {

  constructor(private route: ActivatedRoute, private productsService: ProductosService, private cartService: CartService) {   }
  product: Product;
  ngOnInit(): void {
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
