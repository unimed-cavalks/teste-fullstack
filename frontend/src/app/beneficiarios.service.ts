import { Injectable } from '@angular/core';
import { Beneficiario } from './beneficiarios/beneficiarios';
import  { HttpClient, HttpParams} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class BeneficiariosService {
  apiUrl: string = environment.apiUrlBase + `/api/beneficiario`;
  
  constructor(private http: HttpClient) { }
  

  salvar(beneficiario: Beneficiario) : Observable<Beneficiario> {
    return this.http.post<Beneficiario>(`${this.apiUrl}`, beneficiario);
  }

  
  getBeneficiarios(params?: any) : Observable<Beneficiario[]>{
    let httpParams = new HttpParams();
    for (const key in params) {
      if (params.hasOwnProperty(key) && params[key]) {
        httpParams = httpParams.append(key, params[key].toString());
      }
    }
    return this.http.get<Beneficiario[]>(`${this.apiUrl}`, { params: httpParams});
  }

  getProductPage(page, size) : Observable<Beneficiario[]> {
    return this.http.get<Beneficiario[]>(`http://localhost:8080/api/beneficiario?pageSize=${page}&pageNumber=${size}`);
  }

  getBeneficiarioById(id: number) : Observable<Beneficiario>{
    return this.http.get<any>(`http://localhost:8080/api/beneficiario/${id}`);
  }

  updateBeneficiario(beneficiario: Beneficiario)  : Observable<any>{
    return this.http.put<Beneficiario>(`http://localhost:8080/api/beneficiario/${beneficiario.id}`, beneficiario);
  }

  deleteBeneficiario(beneficiario: Beneficiario) : Observable<any>{
    return this.http.delete<any>(`http://localhost:8080/api/beneficiario/${beneficiario.id}`);
  }



  
}
