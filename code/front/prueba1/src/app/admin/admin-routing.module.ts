import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {NavComponent} from './components/nav/nav.component';
import {InventarioListComponent} from './components/inventario-list/inventario-list.component';
import { InventarioCreateComponent } from './components/inventario-create/inventario-create.component';
import { ReporteOrdenesComponent } from './components/reporteOrdenes/reporteOrdenes.component';
import { ReporteProductosComponent } from './components/reporteProductos/reporteProductos.component';
import { ReportePromocionesComponent } from './components/reportePromociones/reportePromociones.component';

const routes: Routes = [
  {
    path: '',
    component: NavComponent,
    children: [
      {
        path: 'inventario/crear',
        component: InventarioCreateComponent
      },
      {
        path: 'inventario/crear/:id',
        component: InventarioCreateComponent
      },
      {
        path: 'inventario',
        component: InventarioListComponent
      },
      {
        path: 'reporteOrdenes',
        component: ReporteOrdenesComponent
      },
      {
        path: 'reporteProductos',
        component: ReporteProductosComponent
      },
      {
        path: 'reportePromociones',
        component: ReportePromocionesComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
