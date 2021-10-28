import { Injectable } from '@angular/core';
import {Login} from '../../entity/login.model';
import {Result} from '../../entity/result.model';
import {HttpClient,HttpErrorResponse} from '@angular/common/http';
import { Observable,throwError } from 'rxjs';
import {environment} from '../../../../environments/environment';
import { map,catchError,retry } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  result: Boolean = false;
  constructor(private http: HttpClient) {

  }

  getLogin(login: Login): Boolean
  {
    this.http.post(`${environment.url_api}/autenticacion/login`, login).pipe(
      retry(3),
      catchError(this.handleError),
      map((response: any) => {this.result =true;})
    );
    return this.result;
  }

  private handleError(error: HttpErrorResponse) {
    this.result =false;
    return throwError('Something bad happened; please try again later.');
  }
  
}
