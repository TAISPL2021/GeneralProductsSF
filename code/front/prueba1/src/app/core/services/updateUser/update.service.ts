import { Injectable } from '@angular/core';
import {Update} from '../../entity/update.model';
import {HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from '../../../../environments/environment';
import { Result } from '../../entity/result.model';

@Injectable({
  providedIn: 'root'
})
export class UpdateService {
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

  Update(Update: Partial<Update>): any{

    console.log(JSON.stringify(Update));
    /*const headers= new HttpHeaders()
    .set('content-type', 'application/json')
    .set('Access-Control-Allow-Origin', '*')
    .set('Access-Control-Request-Headers', '*')
    .set('Access-Control-Request-Method', '*');*/
    /*return this.http.post(`${environment.url_api}/autenticacion/registro`, register,{'headers': headers})*/
    return this.http.put(`${environment.url_api}/autenticacion/actualizar`, Update)
   
  }

}
