import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BeneficiariosFormComponent } from './beneficiarios-form/beneficiarios-form.component'
import { BeneficiariosListaComponent } from './beneficiarios-lista/beneficiarios-lista.component';

const routes: Routes = [
  { path:'beneficiarios-form' , component: BeneficiariosFormComponent},
  { path:'beneficiarios-form/:id' , component: BeneficiariosFormComponent},
  { path:'beneficiarios-lista' , component: BeneficiariosListaComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BeneficiariosRoutingModule { }
