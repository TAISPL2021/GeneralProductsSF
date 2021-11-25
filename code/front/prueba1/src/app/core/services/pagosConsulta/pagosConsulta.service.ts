import { Injectable } from '@angular/core';
import {PagoConsulta} from '../../entity/pagoConsulta';
import {HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PagosConsultaService {
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

  getAllUsers(nombre: string): Observable<PagoConsulta[]>
  {
    console.log(`${environment.url_api}/pago/all`);
    return this.http.get<PagoConsulta[]>(`${environment.url_api}/pago/all`);
  }

}
