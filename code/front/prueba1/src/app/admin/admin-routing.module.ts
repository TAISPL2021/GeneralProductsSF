import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {NavComponent} from './components/nav/nav.component';
import {InventarioListComponent} from './components/inventario-list/inventario-list.component';
import { InventarioCreateComponent } from './components/inventario-create/inventario-create.component';
import { ReportesComponent } from './components/reportes/reportes.component';

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
        path: 'reportes',
        component: ReportesComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
