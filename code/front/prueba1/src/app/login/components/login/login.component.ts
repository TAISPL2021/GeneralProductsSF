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

  constructor(private formBuilder: FormBuilder, private loginService: LoginService, private router: Router, private cookieService: CookieService) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        user: ['', [Validators.required]],
        password: ['', [Validators.required]],
      }
    );
  }


  SaveProduct( event: Event): any{
    event.preventDefault();
    if (this.form.valid){
      this.login = this.form.value;
      console.log(this.login);
      /*this.loginService.getLogin(login).subscribe( (newproduct) => {
        console.log(newproduct);
        this.router.navigate(['./admin/products']);
      });*/
      alert(this.login.user);
      this.cookieService.set("user", this.login.user);
      this.router.navigate(['./admin/inventario']);
    }
    else{
      alert('datos invalidos');
    }
  }
  getErrorMessage(): any{
    return "Usuario Invalido"
  }

}
