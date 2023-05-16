import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isAuthenticated: any;
  storeToken(token: any) {
    throw new Error('Method not implemented.');
  }
  private apiUrl = 'http://localhost:8080'; // URL do backend

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/login`, { username, password });
  }

  // métodos para armazenar e obter o token JWT do armazenamento local do navegador
  // ...

  // método para verificar se o usuário está autenticado
  // ...

  // método para fazer logout e remover o token do armazenamento local
  // ...
}
