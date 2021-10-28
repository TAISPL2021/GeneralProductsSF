import { Injectable } from '@angular/core';
import {Register} from '../../entity/register.model';
import {HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from '../../../../environments/environment';
import { Result } from '../../entity/result.model';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
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

  createRegister(register: Partial<Register>): any{

    console.log(JSON.stringify(register));
    /*const headers= new HttpHeaders()
    .set('content-type', 'application/json')
    .set('Access-Control-Allow-Origin', '*')
    .set('Access-Control-Request-Headers', '*')
    .set('Access-Control-Request-Method', '*');*/
    /*return this.http.post(`${environment.url_api}/autenticacion/registro`, register,{'headers': headers})*/
    return this.http.post(`${environment.url_api}/autenticacion/registro`, register)
   
  }

}
