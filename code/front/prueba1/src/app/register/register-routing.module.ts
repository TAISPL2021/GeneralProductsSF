import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules} from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
const routes: Routes = [
    {
        path : '',
        component : RegisterComponent
    }
];
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class RegisterRoutingModule {}