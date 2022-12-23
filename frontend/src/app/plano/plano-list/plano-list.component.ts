import { Plano } from './../Plano';
import { PlanoService } from '../../plano.service';
import { PlanoBusca } from '../PlanoBusca';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-plano-list',
  templateUrl: './plano-list.component.html',
  styleUrls: ['./plano-list.component.css']
})
export class PlanoListComponent implements OnInit {


  planoSelecionado: Plano;
  nome: '';
  planos: PlanoBusca[];
  pageNumber = 0;
  pageSize = 10;
  message: string;
  mensagemSucesso: string;
  mensagemErro : string;

  constructor(private service : PlanoService ) { }

  ngOnInit() {
    this.buscar();
  }


  preparaPlano(plano: Plano) {
    this.planoSelecionado = plano;
  }


  deletar() {
    this.service
    .deletePlano(this.planoSelecionado)
    .subscribe( 
      response => { this.mensagemSucesso = 'Plano deletado com sucesso.'
      this.ngOnInit();
    },
      erroResponse  => {this.mensagemErro = 'Ocorreu um erro ao deletar'}
    )
      
   console.log("SELECIONADO", this.planoSelecionado);
  }

  buscar() {
    let params = {};
      params = {
        nome: this.nome,
        pageSize: this.pageSize,
        pageNumber: this.pageNumber,
      };  
      params = { nome: this.nome };

    this.service.buscar(params)
      .subscribe( response => {
        this.planos = response
        if( this.planos.length <= 0 ) {
          this.message = "Nenhum registro encontrado.";
        } else {
          this.message = null;
        }
      })
  }
}
