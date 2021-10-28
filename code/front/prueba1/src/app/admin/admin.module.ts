import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import {MaterialModule} from './../material/material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { NavComponent } from './components/nav/nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { InventarioListComponent } from './components/inventario-list/inventario-list.component';
import { InventarioCreateComponent } from './components/inventario-create/inventario-create.component';




@NgModule({
  declarations: [
    
    NavComponent,
    
    
    InventarioListComponent,
    InventarioCreateComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    MaterialModule,
    LayoutModule
  ]
})
export class AdminModule { }
