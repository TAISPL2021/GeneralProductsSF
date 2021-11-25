import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import {MaterialModule} from './../material/material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { NavComponent } from './components/nav/nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { InventarioListComponent } from './components/inventario-list/inventario-list.component';
import { InventarioCreateComponent } from './components/inventario-create/inventario-create.component';
import { PromotionCreateComponent } from './components/promotion-create/promotion-create.component';
import { ReporteOrdenesComponent } from './components/reporteOrdenes/reporteOrdenes.component';
import { ReporteProductosComponent } from './components/reporteProductos/reporteProductos.component';
import { ReportePromocionesComponent } from './components/reportePromociones/reportePromociones.component';
import { MatMenuModule } from '@angular/material/menu';
import { PedidosListComponent } from './components/pedidos-list/pedidos-list.component';
import { PromotionListComponent } from './components/promotion-list/promotion-list.component';
import { UsuariosListComponent } from './components/usuarios-list/usuarios-list.component';
import { PagosListComponent } from './components/pagos-list/pagos-list.component';

@NgModule({
  declarations: [
    
    NavComponent,

    InventarioListComponent,
    InventarioCreateComponent,
    PromotionListComponent,
    PromotionCreateComponent,
    ReporteOrdenesComponent,
    ReporteProductosComponent,
    ReportePromocionesComponent,
    PedidosListComponent,
    UsuariosListComponent,
    PagosListComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    MaterialModule,
    LayoutModule,
    MatMenuModule,
    
  ]
})
export class AdminModule { }
