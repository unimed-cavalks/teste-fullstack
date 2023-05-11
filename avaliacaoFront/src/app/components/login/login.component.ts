import { Component } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  //login: string;
  //senha: string;
  public login = '';
  public senha = '';

  constructor(private authService: AuthService) { }

  fazerLogin(): void {
    this.authService.login(this.login, this.senha).subscribe(
      response => {
        // Armazene o token JWT retornado no armazenamento local do navegador
        this.authService.storeToken(response.token);

           // Redirecione o usuário para a página inicial (dashboard)
           window.location.href = '/dashboard';
         },
         error => {
           // Trate o erro de autenticação
         }
       );
     }
}
