import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Beneficiario } from 'src/app/models/beneficiario.model';

@Injectable({
  providedIn: 'root'
})
export class BeneficiarioService {
  private apiUrl = 'http://localhost:8080/beneficiarios';

  constructor(private http: HttpClient) {}

  getBeneficiarios(): Observable<Beneficiario[]> {
    return this.http.get<Beneficiario[]>(this.apiUrl);
  }

  addBeneficiario(beneficiario: Beneficiario): Observable<Beneficiario> {
    return this.http.post<Beneficiario>(this.apiUrl, beneficiario);
  }

  updateBeneficiario(beneficiario: Beneficiario): Observable<Beneficiario> {
    return this.http.put<Beneficiario>(`${this.apiUrl}/${beneficiario.Id}`, beneficiario);
  }

  deleteBeneficiario(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}

