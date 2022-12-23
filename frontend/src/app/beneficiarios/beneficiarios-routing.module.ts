import { LayoutComponent } from '../layout/layout.component';
import { BeneficiariosListaComponent } from './beneficiarios-lista/beneficiarios-lista.component';
import { BeneficiariosFormComponent } from './beneficiarios-form/beneficiarios-form.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard} from '../auth.guard';

const routes: Routes = [
  { path: 'beneficiarios', component: LayoutComponent,canActivate : [AuthGuard], children: [
    { path: 'form', component: BeneficiariosFormComponent},
    { path: 'form/:id', component: BeneficiariosFormComponent},
    { path: 'lista', component: BeneficiariosListaComponent},
    { path: '', redirectTo: '/beneficiarios/lista', pathMatch: 'full' }
  ] }
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BeneficiariosRoutingModule { }
