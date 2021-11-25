import { Injectable } from '@angular/core';
import {User} from '../../entity/user.model';
import {UserDelete} from '../../entity/userDelete.model';
import {HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {
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

  getAllUsers(nombre: string): Observable<User[]>
  {
    console.log(`${environment.url_api}/administracion/user/control`);
    return this.http.get<User[]>(`${environment.url_api}/administracion/user/control`);
  }

  disabledUsuarios(changes: Partial<UserDelete>): any
  {
    console.log(JSON.stringify(changes));
    return this.http.post(`${environment.url_api}/administracion/user/control`, changes);
  }

}
