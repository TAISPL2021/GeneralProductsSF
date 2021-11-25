import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Order } from './../../entity/order.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }

  Header(): any{
    const httpOptions = {
      headers: new HttpHeaders({
        'Access-Control-Allow-Origin':  'true',
      })
    };
    return httpOptions;
  }
  
  getAll(nombre: string): Observable<Order[]>
  {
    return this.http.get<Order[]>(`${environment.url_api}//`);
  }

  BuyNow(order: Partial<Order>,idcarrito: number): any
  {
    console.log(JSON.stringify(order));
    return this.http.post<Order[]>(`${environment.url_api}/carrito/checkout/${idcarrito}`,order);
  }
}
