import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import {MaterialModule} from './../material/material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { NavComponent } from './components/nav/nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { InventarioListComponent } from './components/inventario-list/inventario-list.component';
import { InventarioCreateComponent } from './components/inventario-create/inventario-create.component';
import { ReporteOrdenesComponent } from './components/reporteOrdenes/reporteOrdenes.component';
import { ReporteProductosComponent } from './components/reporteProductos/reporteProductos.component';
import { ReportePromocionesComponent } from './components/reportePromociones/reportePromociones.component';
import { MatMenuModule } from '@angular/material/menu';


@NgModule({
  declarations: [
    
    NavComponent,
    
    
    InventarioListComponent,
    InventarioCreateComponent,
    ReporteOrdenesComponent,
    ReporteProductosComponent,
    ReportePromocionesComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    MaterialModule,
    LayoutModule,
    MatMenuModule
    
  ]
})
export class AdminModule { }
