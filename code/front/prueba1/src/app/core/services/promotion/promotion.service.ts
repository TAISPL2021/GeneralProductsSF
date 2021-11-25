import { Injectable } from '@angular/core';
import {Promotion} from '../../entity/promotion.model';
import {HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from '../../../../environments/environment';
import { Result } from '../../entity/result.model';

@Injectable({
  providedIn: 'root'
})
export class PromotionService {
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

  getAllPromotion(nombre: string): Observable<Promotion[]>
  {
    const headers= new HttpHeaders()
    .set('filter', '3');
    return this.http.get<Promotion[]>(`${environment.url_api}/administracion/promocion`,{'headers': headers});
  }

  getPromotionForId(id: number): Observable<Promotion[]>
  {
    return this.http.get<Promotion[]>(`${environment.url_api}/administracion/promocion/${id}`);
  }

  createPromotion(promotion: Partial<Promotion>): any{

    console.log(JSON.stringify(promotion));
    console.log('create');
    const headers= new HttpHeaders()
    .set('content-type', 'application/json')
    .set('Access-Control-Allow-Origin', '*')
    .set('Access-Control-Request-Headers', '*')
    .set('Access-Control-Request-Method', '*');
    return this.http.post(`${environment.url_api}/administracion/promocion`, promotion,{'headers': headers})
   
  }

  updatePromotion(changes: Partial<Promotion>): any
  {
    console.log(JSON.stringify(changes));
    return this.http.put(`${environment.url_api}/administracion/promocion`, changes);
  }

}
