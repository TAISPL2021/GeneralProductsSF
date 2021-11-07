import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validator, Validators} from '@angular/forms';
import {Result} from '../../../../../core/entity/result.model';
import {Router} from '@angular/router';
import {UpdateService} from './../../../../../core/services/updateUser/update.service';
import {Update} from '../../../../../core/entity/update.model';

@Component({
  selector: 'app-login',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {

  form: FormGroup;
  update: Update
  hide = true;

  constructor(private formBuilder: FormBuilder, private updateService: UpdateService, private router: Router) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group(
      {
        name: ['', [Validators.required]],
        secondName: ['', [Validators.required]],
        lastName:['', [Validators.required]],
        secondLastName:['', [Validators.required]],
        address: ['', [Validators.required]],
        phone: ['', [Validators.required]],
        gender: ['', [Validators.required]],
        userName: ['', [Validators.required]],
        email: ['', [Validators.required]],
        password: ['', [Validators.required]],
        role: ['', [Validators.required]],
      }
    );
  }

  SaveUpdate( event: Event): any{

    event.preventDefault();
    if (this.form.valid){
      const update = this.form.value;
      this.updateService.Update(update).subscribe( (update) => {
        console.log(update);
        alert('Cuenta Actualizada!');
        this.router.navigate(['/home']);
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