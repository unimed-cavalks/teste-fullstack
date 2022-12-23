import { BeneficiariosService } from './../../beneficiarios.service';
import { Observable } from 'rxjs';

import { Beneficiario } from '../beneficiarios';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
@Component({
  selector: 'app-beneficiarios-form',
  templateUrl: './beneficiarios-form.component.html',
  styleUrls: ['./beneficiarios-form.component.css']
})
export class BeneficiariosFormComponent implements OnInit {

  beneficiario: Beneficiario;
  success: boolean = false;
  errors: String[];
  id: number;

  constructor(private service: BeneficiariosService, 
              private router: Router, 
              private activeRoute: ActivatedRoute) { 
      this.beneficiario = new Beneficiario();
    
  }

  ngOnInit() {
    let params : Observable<Params> = this.activeRoute.params

    params.subscribe( urlParams => {
      this.id = urlParams['id'];
      if(this.id) {
        this.service.getBeneficiarioById(this.id)
        .subscribe(response => this.beneficiario = response,
        erroResponse => this.beneficiario = new Beneficiario()
      );
      }
    })
  }


  onSubmit(){
    if(this.beneficiario.id ){
      this.service.updateBeneficiario(this.beneficiario)
      .subscribe( 
        response => {
          this.success = true;
          this.errors = null;
          console.log("RESULT",this.beneficiario)
        }, erroResponse => {
          this.errors = ['Erro ao atualizar'];
        });
    }else {
      this.service.salvar(this.beneficiario)
      .subscribe( response => {
      this.success = true;
      this.errors = null;
    } , errorResponse => {
      this.success = false;
        this.errors = errorResponse.error.errors;
      }
    )
    }
  }


  voltar() {
    this.router.navigate(['/beneficiarios/lista'])
  }

}
