import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {LayoutComponent} from './layout/layout.component';
import {AdminGuard} from './admin.guard';
const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children : [
      {
        path : '',
        redirectTo : 'home',
        pathMatch : 'full'
      },
      {
        path : 'home',
        loadChildren: () => import('./home/home.module').then(m => m.HomeModule)
      },
      {
        path : 'products',
        loadChildren: () => import('./product/product.module').then(m => m.ProductModule)
      },
      {
        path : 'order',
        loadChildren: () => import('./order/order.module').then(m => m.OrderModule)
      },
      {
        path : 'register',
        loadChildren: () => import('./register/register.module').then(m => m.RegisterModule)
      },
      {
        path : 'login',
        loadChildren: () => import('./login/login.module').then(m => m.LoginModule)
      }
    ]
  },
  {
    path: 'admin',
    loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule),
    canActivate: [AdminGuard]
  },
  {
    path : '**',
    component : PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
