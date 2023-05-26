import { Component } from '@angular/core';
import { Beneficiario } from '../Beneficiario';
import {BeneficiariosService} from '../../beneficiarios.service';

import { Router, ActivatedRoute } from '@angular/router'

@Component({
  selector: 'app-beneficiarios-form',
  templateUrl: './beneficiarios-form.component.html',
  styleUrls: ['./beneficiarios-form.component.css']
})
export class BeneficiariosFormComponent {

  beneficiario: Beneficiario;
  success: boolean = false;
  errors: String[];
  id:number;

  constructor(
    private service: BeneficiariosService,
    private router: Router,
    private activatedRoute: ActivatedRoute ){
    this.beneficiario = new Beneficiario();
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      if (params && params.hasOwnProperty('id')) {
        this.id = params['id'];
        this.service.getBeneficiarioById(this.id).subscribe(
          response => {
            this.beneficiario = response;
          },
          errorresponse => {
            this.beneficiario = new Beneficiario();
          }
        );
      }
    });
  }

  /*ngOnInit(): void {
    let params = this.activatedRoute.params
    if(params && params.value && params.value.id){
      this.id = params.value.id;
      this.service
      .getBeneficiarioById(this.id)
      .subscribe(
        response => this.beneficiario = response,
        errorresponse => this.beneficiario = new Beneficiario();)
    }
  }

  ngOnInit():void{
    let params = this.activatedRoute.params
    if(params && params.value && params.value.id){
      console.log(params.value.id)
    }
  }*/

  voltarParaListagem(){
    this.router.navigate(['beneficiarios-lista'])
  }

  onSubmit(){
    this.service
    .salvar(this.beneficiario)
    .subscribe(response =>{
      this.success = true;
    }, errorResponse =>{
      this.success = false;
      this.errors = errorResponse.error.errors;
    })
  }

}
