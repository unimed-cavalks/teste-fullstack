import { Component} from '@angular/core';
import { Router } from '@angular/router'

import { Beneficiario } from '../Beneficiario';
import { BeneficiariosService } from '../../beneficiarios.service';


@Component({
  selector: 'app-beneficiarios-lista',
  templateUrl: './beneficiarios-lista.component.html',
  styleUrls: ['./beneficiarios-lista.component.css']
})
export class BeneficiariosListaComponent {

  beneficiarios: Beneficiario[] = [];
  beneficiarioSelecionado: Beneficiario;
  mensagemSucesso: string;

  constructor(
    private service: BeneficiariosService,
    private router : Router ){ }

  ngOnInit():void{
   this.service
   .getBeneficiarios()
   .subscribe ( resposta => this.beneficiarios = resposta );
  }

  novoCadastro(){
    this.router.navigate(['/beneficiarios-form'])
  }

  preparaDelecao(beneficiario : Beneficiario){
    this.beneficiarioSelecionado = beneficiario;
  }

  deletarBeneficiario(){
    this.service
    .deletar(this.beneficiarioSelecionado)
    .subscribe(
      response => {
        this.mensagemSucesso = 'Beneficiario deletado com Sucesso!'
        this.ngOnInit();
    },
    )
  }

}
