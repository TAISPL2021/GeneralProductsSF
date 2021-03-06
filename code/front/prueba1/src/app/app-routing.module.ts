import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {LayoutComponent} from './layout/layout.component';
import {AdminGuard} from './admin.guard';
import { UpdateComponent } from './UpdateUser/components/update.component';

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
        path : 'updateuser',
        loadChildren: () => import('./UpdateUser/update.module').then(m => m.UpdateModule)
      },
      {
        path : 'login',
        loadChildren: () => import('./login/login.module').then(m => m.LoginModule)
      },
      {
        path : 'cart',
        loadChildren: () => import('./cart/cart.module').then(m => m.CartModule)
      },
      {
        path : 'GestionPerfil',
        children: [
          {
            path: 'actualizar',
            component: UpdateComponent
          }
        ]
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
