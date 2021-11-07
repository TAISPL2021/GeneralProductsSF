import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MenuComponent} from './components/menu/menu.component';
import {UpdateComponent} from './components/updateUser/components/update/update.component';

const routes: Routes = [
  {
    path: '',
    component: MenuComponent,
    children: [
      {
        path: 'profileManagement/actualizar',
        component: UpdateComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfileRoutingModule { }