import { PaginationComponent } from '../pagination/pagination.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BeneficiariosRoutingModule } from './beneficiarios-routing.module';
import { BeneficiariosFormComponent } from './beneficiarios-form/beneficiarios-form.component';
import { FormsModule} from '@angular/forms';
import { BeneficiariosListaComponent } from './beneficiarios-lista/beneficiarios-lista.component';
import { AngularPaginatorModule } from 'angular-paginator';



@NgModule({
  declarations: [BeneficiariosFormComponent, BeneficiariosListaComponent, PaginationComponent],
  imports: [
    CommonModule,
    BeneficiariosRoutingModule,
    FormsModule,
    AngularPaginatorModule

  ],
  exports: [BeneficiariosFormComponent, BeneficiariosListaComponent]
})
export class BeneficiarioModule { }
