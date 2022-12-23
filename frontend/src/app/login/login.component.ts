import { AuthService } from './../auth.service';
import { Router } from '@angular/router';
import { Component } from '@angular/core';
import { Usuario } from './usuario';
import { Auth } from 'aws-amplify';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  nome: string;
  login: string;
  senha: string;
  loginError: boolean;
  cadastrando: boolean;
  messageSuccess: string;
  errors: String[];

  constructor(private router: Router, private authservice: AuthService) { }


  onSubmit() {

    this.authservice
          .logar( this.login, this.senha )
          .subscribe(response => {
            const access_token = JSON.stringify(response)
            localStorage.setItem('access_token', access_token)
            console.log("access",access_token)
          this.router.navigate(['/home'])
          }, errorResponse => {
            console.log(errorResponse.error )
            this.errors = [ 'Usuário e/ou senha incorreto(s).' ]
            
          })
    
  }

  logout() {
    localStorage.clear();
    setTimeout(() => {
      this.router.navigate(['/login']);
    }, 1000);
  }

  preparaCadastrar(event){
    event.preventDefault();
    this.cadastrando = true;
  }

  salvar() {
    const user = new Usuario();
    user.nome = this.nome;
    user.login = this.login;
    user.senha = this.senha;
    this.authservice.salvar(user)
    .subscribe( response =>{
      this.messageSuccess = "Cadastro realizado com sucesso! Efetue o login "
      this.loginError = false;
      this.cadastrando = false;
      this.nome = '';
      this.login = '';
      this.senha = '';
    }, error => {
      this.errors = error.error.errors;
      this.loginError = true;
      this.messageSuccess = null;
    })
  }

  cancelaCadastro(){
    this.cadastrando = false;
  }
}
