import { Component, OnInit } from '@angular/core';
import {CartService} from './../../../core/services/cart/cart.service';
import {map} from 'rxjs/operators';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  total: number;
  total2$: Observable<number>;

  constructor(private cartService: CartService) {
    this.total2$ = this.cartService.cart$.pipe(map(products => products.length));
    
    /*this.cartService.cart$.subscribe((products) => {
      this.total = products.length;
    });*/
  }

  ngOnInit(): void {
  }

}
