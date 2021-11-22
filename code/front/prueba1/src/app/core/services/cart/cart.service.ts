import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import {Carrito} from '../../entity/carrito.model';
import {environment} from '../../../../environments/environment';
import {HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private products: Carrito[] =[];
  private cart = new BehaviorSubject<Carrito[]>([]);

  cart$ = this.cart.asObservable();

  constructor(private http: HttpClient ) {
  }

  addCart(product: Carrito): any{
    this.AddCarrito(product);
    this.products = [...this.products, product];
    this.cart.next(this.products);
  }

  AddCarrito(carrito: Partial<Carrito>): any{

    console.log(JSON.stringify(carrito));
    const headers= new HttpHeaders()
    .set('content-type', 'application/json')
    .set('Access-Control-Allow-Origin', '*')
    .set('Access-Control-Request-Headers', '*')
    .set('Access-Control-Request-Method', '*');
    return this.http.post(`${environment.url_api}/carrito/incluir`, carrito,{'headers': headers})
   
  }

  getAllProduct(nombre: string): Observable<Carrito[]>
  {
    return this.http.get<Carrito[]>(`${environment.url_api}/carrito/pepito`);
  }


}
