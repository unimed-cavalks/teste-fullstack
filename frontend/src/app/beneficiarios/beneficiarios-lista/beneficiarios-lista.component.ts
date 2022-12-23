import { BeneficiariosService } from '../../beneficiarios.service';
import { Beneficiario } from '../beneficiarios';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Page } from '../Page';

@Component({
  selector: 'app-beneficiarios-lista',
  templateUrl: './beneficiarios-lista.component.html',
  styleUrls: ['./beneficiarios-lista.component.css']
})
export class BeneficiariosListaComponent implements OnInit {

  beneficiarios: Beneficiario[] = [];
  beneficiario: Beneficiario;
  mensagemSucesso: string;
  mensagemErro : string;

  beneficiarioSelecionado: Beneficiario;
  private page : Page;
  name = '';
  cpf = '';
  pageNumber = 0;
  pageSize = 10;
  pag : Number = 1 ;
  contador : Number = 5;
  constructor(
    private service : BeneficiariosService, 
    private router: Router,
    private activeRoute: ActivatedRoute) { }

  ngOnInit() {
    this.getBeneficiarios();
    this.pageProducts(10, 0);
  }

getBeneficiarios() {
  let params = {};
      params = {
        name: this.name,
        cpf: this.cpf,
        pageSize: this.pageSize,
        pageNumber: this.pageNumber,
      };
      console.log('PARAM', params)
  this.service.getBeneficiarios(params)
  .subscribe( response => this.beneficiarios = response);
}

novoCadastro() {
  this.router.navigate(['/beneficiarios/form'])
}

 pageProducts(page, size){
    this.service.getProductPage(page, size).subscribe(res => {
      this.beneficiarios = res;
      console.log(this.beneficiarios)
    });
  }

  preparaBeneficiario(beneficiario: Beneficiario) {
    this.beneficiarioSelecionado = beneficiario;
  }

  deletar() {
    this.service
    .deleteBeneficiario(this.beneficiarioSelecionado)
    .subscribe( 
      response => { this.mensagemSucesso = 'Beneficiário deletado com sucesso.'
      this.ngOnInit();
    },
      erroResponse  => {this.mensagemErro = 'Ocorreu um erro ao deletar'}
    )
      
   console.log("SELECIONADO", this.beneficiarioSelecionado);
  }

  changePage(event){
   this.pageProducts(event.page, event.size);
  }

  

  
}
