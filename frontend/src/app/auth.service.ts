import { environment } from './../environments/environment';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Usuario } from './login/usuario';
import {  JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  apiUrl: string   =   environment.apiUrlBase + "/api/user"
  tokenUrl: string = environment.apiUrlBase + environment.obterTokenUrl;  
  clientID: string = environment.clientId;
  clientSecret: string = environment.clientSecret;
  jwtHelper: JwtHelperService = new JwtHelperService();

  salvar(user: Usuario) : Observable<Usuario> {
    return this.http.post<Usuario>(this.apiUrl, user);
  }

  obterToken() {
    const tokenString = localStorage.getItem("access_token")
    if( tokenString){
      const token = JSON.parse(tokenString).access_token
      return token;
    }
      return null;
  }

  encerrarSessao(){
    localStorage.removeItem('access_token')
  }

  getUsuarioLogado(){
   const token =  this.obterToken()
   if( token ){
     const usuario = this.jwtHelper.decodeToken(token).user_name
     return usuario;
   }
   return null;
  }

  authenticated(): boolean {
    const token  = this.obterToken();
    if(token) {
      const expired = this.jwtHelper.isTokenExpired(token)
      return !expired;
    }
    return false;
  }

  logar(username: string, password: string): Observable<any>{
    const params = new HttpParams()
                      .set('username', username)
                      .set('password', password)
                      .set('grant_type', 'password');

    const headers = {
      'Authorization' : 'Basic ' + btoa(`${this.clientID}:${this.clientSecret}`),
      'Content-Type'  : 'application/x-www-form-urlencoded'
    }
    console.log(this.tokenUrl + params.toString())
    return this.http.post(this.tokenUrl, params.toString(), { headers });
  }
}
