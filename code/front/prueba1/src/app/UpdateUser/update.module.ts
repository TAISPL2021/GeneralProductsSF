import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UpdateComponent } from './components/update.component';
import {MaterialModule} from './../material/material.module';
import {UpdateRoutingModule} from './update-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    UpdateComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    UpdateRoutingModule,
    ReactiveFormsModule
  ]
})
export class UpdateModule { }
