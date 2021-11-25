import { Injectable } from '@angular/core';
import { BehaviorSubject, throwError } from 'rxjs';
import {Carrito} from '../../entity/carrito.model';
import {CarritoRensponse} from '../../entity/carritoResponse.model';
import {environment} from '../../../../environments/environment';
import {HttpClient,HttpErrorResponse,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private products: Carrito[] =[];
  private cart = new BehaviorSubject<Carrito[]>([]);

  cart$ = this.cart.asObservable();

  constructor(private http: HttpClient ) {
  }

  addCart(product: Carrito): any{
    return this.AddCarrito(product);
    /*this.products = [...this.products, product];
    this.cart.next(this.products);*/
  }

  AddCarrito(carrito: Partial<Carrito>): any{

    console.log(JSON.stringify(carrito));
    console.log(`${environment.url_api}/carrito/incluir`);
    /*const headers= new HttpHeaders()
    .set('content-type', 'application/json')
    .set('Access-Control-Allow-Origin', '*')
    .set('Access-Control-Request-Headers', '*')
    .set('Access-Control-Request-Method', '*');*/
    return this.http.post<CarritoRensponse>(`${environment.url_api}/carrito/incluir`, carrito/*,{'headers': headers}*/).pipe(
      catchError(this.handleError)
    );   
  }

  getAllProduct(nombre: string): Observable<Carrito[]>
  {
    return this.http.get<Carrito[]>(`${environment.url_api}/carrito/pepito`);
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(
      'Something bad happened; please try again later.');
  }


}
