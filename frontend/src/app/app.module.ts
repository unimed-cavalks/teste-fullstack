import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import{TemplateModule} from './template/template.module';
import { HomeComponent } from './home/home.component'
import { BeneficiariosModule } from './beneficiarios/beneficiarios.module';
import { BeneficiariosService } from './beneficiarios.service'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    TemplateModule,
    BeneficiariosModule
  ],
  providers: [
    BeneficiariosService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
