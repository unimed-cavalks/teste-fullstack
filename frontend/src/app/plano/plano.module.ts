import { PlanoRoutingModule } from './plano-routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlanoFormComponent } from './plano-form/plano-form.component';
import { PlanoListComponent } from './plano-list/plano-list.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router'
@NgModule({
  declarations: [PlanoFormComponent, 
    PlanoListComponent],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    PlanoRoutingModule
  ],
  exports: [
    PlanoFormComponent, 
    PlanoListComponent  ]
})
export class PlanoModule { }
