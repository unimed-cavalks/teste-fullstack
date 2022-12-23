import { TokenInterceptor } from './../interceptors/token.interceptor';
import { AuthService } from './auth.service';
import { FormsModule } from '@angular/forms';
import { PlanoService } from './plano.service';
import { BeneficiarioModule } from './beneficiarios/beneficiarios.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { TemplateModule } from './template/template.module';
import { HomeComponent } from './home/home.component';
import { BeneficiariosService } from './beneficiarios.service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { PlanoModule } from './plano/plano.module';
import { LoginComponent } from './login/login.component';
import { LayoutComponent } from './layout/layout.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    LayoutComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    TemplateModule,
    BeneficiarioModule,
    FormsModule,
    PlanoModule
  ],  
  providers: [
    BeneficiarioModule, PlanoService, AuthService, 
    {
       provide: HTTP_INTERCEPTORS, 
       useClass: TokenInterceptor,
       multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
