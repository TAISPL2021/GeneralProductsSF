import { Injectable } from '@angular/core';
import {Product} from '../../entity/product.model';
import {Promotion} from '../../entity/promotion.model';
import {Order} from '../../entity/order.model';
import {HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from '../../../../environments/environment';
import { Result } from '../../entity/result.model';
import { Pedidos } from '../../entity/pedidos.model';

@Injectable({
  providedIn: 'root'
})
export class ReportsService {
  constructor(private http: HttpClient) {

  }

  Header(): any{
    const httpOptions = {
      headers: new HttpHeaders({
        'Access-Control-Allow-Origin':  'true',
      })
    };
    return httpOptions;
  }

  getListProductosFromInventario(monthly: boolean): Observable<Product[]>
  {
    return this.http.get<Product[]>(`${environment.url_api}/inventario/producto`);
  }

  getListPromFromInventario(monthly: boolean): Observable<Promotion[]>
  {
    const headers= new HttpHeaders()
    .set('filter', '3');
    return this.http.get<Promotion[]>(`${environment.url_api}/administracion/promocion`,{'headers': headers});
  }

  getListOrders(monthly: boolean): Observable<Pedidos[]>
  {
    return this.http.get<Pedidos[]>(`${environment.url_api}/administracion/pedido`);
  }
}
