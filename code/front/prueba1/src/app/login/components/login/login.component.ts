import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validator, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {LoginService} from './../../../core/services/login/login.service';
import {Result} from '../../../core/entity/result.model';
import {Login} from '../../../core/entity/login.model';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form: FormGroup;
  login: Login
  hide = true;
  mock = false;

  constructor(private formBuilder: FormBuilder, private loginService: LoginService, private router: Router, private cookieService: CookieService) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        userName: ['', [Validators.required]],
        password: ['', [Validators.required]],
      }
    );
  }


  Savelogin( event: Event): any{
    event.preventDefault();
    if (this.form.valid){
      this.login = this.form.value;
      console.log(this.login);

      if(this.mock == true){
        var json = '{"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJGbW9yZW5vVDI1IiwiaWF0IjoxNjM1MzQ0NTA4LCJleHAiOjE2MzUzODA1MDh9.HWWmXBV3mrlDRilqepnobmXh7BhoHtasaUaPYwFbm3fgsjNUaP1KaH2A2q0eUa678vqBkM3-e0JhTN3Ux60d_Q","bearer": "Bearer","nombreUsuario": "FmorenoT25","authorities": [{"authority": "ADMIN"}]}'
        var login=JSON.parse(json);
        this.cookieService.set("userName", this.login.userName);
        this.cookieService.set("rol", login.authorities[0].authority);
        this.router.navigate(['./admin/inventario']);

      }
      this.loginService.getLogin(this.login).subscribe( (login) => {
        console.log(login.authorities[0].authority);
        if (login.hasOwnProperty('nombreUsuario')) {
          this.cookieService.set("userName", this.login.userName);
          this.cookieService.set("rol", login.authorities[0].authority);
          if (login.authorities[0].authority = 'ADMIN') {
            //this.router.navigate(['/home']);
            this.router.navigate(['./admin/inventario']);
          }
          else {
            this.router.navigate(['/order']);
          }
        }
        else {
          alert('datos invalidos');
        }
      });      
    }
    else{
      alert('datos invalidos');
    }
  }
  getErrorMessage(): any{
    return "Usuario Invalido"
  }

}
