import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validator, Validators} from '@angular/forms';
import {Result} from '../../../core/entity/result.model';
import {Router} from '@angular/router';
import {RegisterService} from './../../../core/services/register/register.service';
import {Register} from '../../../core/entity/register.model';

@Component({
  selector: 'app-login',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  form: FormGroup;
  register: Register
  hide = true;

  constructor(private formBuilder: FormBuilder, private registerService: RegisterService, private router: Router) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        name: ['', [Validators.required]],
        secondName: [''],
        lastName:['', [Validators.required]],
        secondLastName:[''],
        address: ['', [Validators.required]],
        phone: ['', [Validators.required]],
        gender: [''],
        userName: ['', [Validators.required]],
        email: ['', [Validators.required]],
        password: ['', [Validators.required]],
        role: ['', [Validators.required]],
      }
    );
  }

  SaveRegister( event: Event): any{

    event.preventDefault();
    if (this.form.valid){
      const register = this.form.value;
      console.log(this.register);
      this.registerService.createRegister(register).subscribe( (newregister) => {
        console.log(newregister);
        alert('Cuenta Creada!');
        this.router.navigate(['/login']);
      });
    }
    else{
      alert('datos invalidos');
    } 
  }

  getErrorMessage(): any{
    return "Campo obligatorio"
  }

}