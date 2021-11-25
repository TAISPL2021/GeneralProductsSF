import { Injectable } from '@angular/core';
import {Pedidos} from '../../entity/pedidos.model';
import {HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from '../../../../environments/environment';
import { Result } from '../../entity/result.model';

@Injectable({
  providedIn: 'root'
})
export class PedidosService {
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

  getAllPedidos(nombre: string): Observable<Pedidos[]>
  {
    return this.http.get<Pedidos[]>(`${environment.url_api}/administracion/pedido`);
  }

  updateProduct(idpedidos: number): any
  {
    return this.http.put(`${environment.url_api}/administracion/pedido/${idpedidos}`,"");
  }

}
