import { Component, OnInit } from '@angular/core';
import {CartService} from './../../../core/services/cart/cart.service';
import {map} from 'rxjs/operators';
import { Observable } from 'rxjs';
import {environment} from '../../../../environments/environment';
import { CookieService } from 'ngx-cookie-service';
import {Router} from '@angular/router';
import { throwMatDuplicatedDrawerError } from '@angular/material/sidenav';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  total: number;
  total2$: Observable<number>;
  programacion: any;
  version: string;
  sesion: Boolean;

  constructor(private cartService: CartService,private cookieService: CookieService,private router: Router) {
    this.programacion = environment.programacion;
    this.version = environment.Version;
    this.total2$ = this.cartService.cart$.pipe(map(products => products.length));
    
    /*this.cartService.cart$.subscribe((products) => {
      this.total = products.length;
    });*/
  }

  ngOnInit(): void {
    this.sesion =  this.cookieService.check('userName');
  }

  CloseSession(): any{
    this.cookieService.deleteAll('/', 'userName');     
    this.cookieService.delete('userName','/');     
    this.cookieService.deleteAll('/', 'rol');     
    this.cookieService.delete('rol','/');     
    const allCookies: {} = this.cookieService.getAll();
    console.log(allCookies);
    const cookieExists: boolean = this.cookieService.check('userName');
    this.router.navigate(['/home']);
  }

}
