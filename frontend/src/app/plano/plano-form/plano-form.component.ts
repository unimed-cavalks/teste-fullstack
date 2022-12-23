
import { Plano } from '../../plano/Plano';
import { Component, OnInit } from '@angular/core';
import { PlanoService } from 'src/app/plano.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Params } from '@angular/router';

@Component({
  selector: 'app-plano-form',
  templateUrl: './plano-form.component.html',
  styleUrls: ['./plano-form.component.css']
})
export class PlanoFormComponent implements OnInit {

  plano: Plano;
  success:boolean = false;
  errors: String[];
  id: number;
  mensagemSucesso: string;
  mensagemErro : string;

  constructor( private router: Router, 
    private activeRoute: ActivatedRoute,
    private planoService: PlanoService) { 
    this.plano = new Plano();
  }

  ngOnInit() {

    let params : Observable<Params> = this.activeRoute.params

    params.subscribe( urlParams => {
      this.id = urlParams['id'];
      if(this.id) {
        this.planoService.getPlanoById(this.id)
        .subscribe(response => this.plano = response,
        erroResponse => this.plano = new Plano()
      );
      }
    })
  }

      
  onSubmit(){
    if(this.plano.id ){
      this.planoService.updatePlano(this.plano)
      .subscribe( 
        response => {
          this.success = true;
          this.errors = null;
          console.log("RESULT",this.plano)
        }, erroResponse => {
          this.errors = ['Erro ao atualizar'];
        });
      }else{
      this.planoService.salvar(this.plano)
      .subscribe( response => {
      this.success = true; 
      this.errors = null;
      this.plano = new Plano();
       }, 
       erroResponse => {
         this.success= false;
         this.errors = erroResponse.error.errors;
        });
      }
  } 

  voltar() {
    this.router.navigate(['/plano/lista'])
  }

}
