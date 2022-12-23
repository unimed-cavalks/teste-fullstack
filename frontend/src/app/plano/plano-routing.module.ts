import { LayoutComponent } from '../layout/layout.component';
import { PlanoListComponent } from './plano-list/plano-list.component';
import { PlanoFormComponent } from './plano-form/plano-form.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from '../auth.guard';

const routes: Routes = [
  { path:   'plano', component: LayoutComponent,  canActivate : [AuthGuard], children: [
    { path: 'form', component: PlanoFormComponent},
    { path: 'form/:id', component: PlanoFormComponent},
    { path:  'lista', component: PlanoListComponent },
    { path: '', redirectTo: '/plano/lista', pathMatch: 'full' }

  ]}
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PlanoRoutingModule { }
