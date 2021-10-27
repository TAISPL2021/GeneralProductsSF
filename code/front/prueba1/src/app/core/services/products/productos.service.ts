import { Injectable } from '@angular/core';
import {Product} from '../../entity/product.model';
import {HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from '../../../../environments/environment';
import { Result } from '../../entity/result.model';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {
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

  getAllProduct(nombre: string): Observable<Product[]>
  {
    return this.http.get<Product[]>(`${environment.url_api}/inventario/producto`);
  }

  getAllProductActive(nombre: string): Observable<Product[]>
  {
    return this.http.get<Product[]>(`${environment.url_api}/catalogo/producto`);
  }

  createProduct(product: Partial<Product>): any{

    console.log(JSON.stringify(product));
    const headers= new HttpHeaders()
    .set('content-type', 'application/json')
    .set('Access-Control-Allow-Origin', '*')
    .set('Access-Control-Request-Headers', '*')
    .set('Access-Control-Request-Method', '*');
    return this.http.post(`${environment.url_api}/inventario/producto`, product,{'headers': headers})
   
  }


  updateProduct(changes: Partial<Product>): any
  {
    console.log(JSON.stringify(changes));
    return this.http.put(`${environment.url_api}/inventario/producto`, changes);
  }

  deleteProduct(id: number): any{
    return this.http.delete(`${environment.url_api}/producto/${id}`);
  }
}
