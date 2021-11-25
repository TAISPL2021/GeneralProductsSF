import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { CookieService } from 'ngx-cookie-service';
import {environment} from '../../../../environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent {

  programacion: any;
  version: string;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver, private cookieService: CookieService, private router: Router) {
    this.programacion = environment.programacion;
    this.version = environment.Version;
  }

  CloseSession(): any{
    this.cookieService.deleteAll('/', 'userName');     
    this.cookieService.delete('userName','/');     
    this.cookieService.deleteAll('/', 'rol');     
    this.cookieService.delete('rol','/');    
    const allCookies: {} = this.cookieService.getAll();
    console.log(allCookies);
    const cookieExists: boolean = this.cookieService.check('userName');
    this.router.navigate(['/products']);
    this.router.navigate(['/promotion']);
    this.router.navigate(['/usuarios']);
  }
}
