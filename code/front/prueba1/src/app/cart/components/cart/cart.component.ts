import { Component, OnInit } from '@angular/core';
import {Carrito} from '../../../core/entity/carrito.model';
import { CookieService } from 'ngx-cookie-service';
import {Router} from '@angular/router';
import { CookieCart } from 'src/app/shared/crosscuting/CookieCart';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {


  carrito: Carrito[]=[];
  
  carritoMock: Carrito[] =[
    {
      id : 1,
      producto_id : "1",
      producto_nombre : "sandwiches",
      producto_detalle : "detaller",
      producto_cantidad : 1,
    },
    {
      id : 2,
      producto_id : "2",
      producto_nombre : "sandwiches de pollo",
      producto_detalle : "detalle 2",
      producto_cantidad : 1,
    }
  ];

  displayedColumns: string[] = ['producto_id', 'producto_nombre', 'producto_cantidad'];

  constructor(private cookieService: CookieService,private router: Router,private cookieCart: CookieCart) { }

  ngOnInit(): void {
    //this.carrito = this.carritoMock
    this.carrito =this.cookieCart.getCookieCart()
  }

  GoToPagar(): void{
    const cookieExists: boolean = this.cookieService.check('userName');
    if(cookieExists){
      this.router.navigate(['./order']);
    }
    else{
      this.router.navigate(['./login']);
    }

  }






}
