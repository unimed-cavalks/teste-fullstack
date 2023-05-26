import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'

import { BeneficiariosRoutingModule } from './beneficiarios-routing.module';
import { BeneficiariosFormComponent } from './beneficiarios-form/beneficiarios-form.component';
import { BeneficiariosListaComponent } from './beneficiarios-lista/beneficiarios-lista.component';


@NgModule({
  declarations: [
    BeneficiariosFormComponent,
    BeneficiariosListaComponent
  ],
  imports: [
    CommonModule,
    BeneficiariosRoutingModule,
    FormsModule
  ], exports:[
    BeneficiariosFormComponent,
    BeneficiariosListaComponent
  ]
})
export class BeneficiariosModule { }
