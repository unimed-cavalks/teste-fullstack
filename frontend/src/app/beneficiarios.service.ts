import { Injectable } from '@angular/core';
import { Beneficiario } from './beneficiarios/Beneficiario';
import { HttpClient} from '@angular/common/http';
import { Observable,empty  } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BeneficiariosService {

  constructor( private http: HttpClient) {}

  salvar(beneficiario:Beneficiario) : Observable<Beneficiario>{
    return this.http.post<Beneficiario>('http://localhost:8080/api/beneficiarios', beneficiario);
  }


  getBeneficiarios() : Observable<Beneficiario[]>{
    return this.http.get<Beneficiario[]>('http://localhost:8080/api/beneficiarios');
  }

  getBeneficiarioById(id: number) : Observable<Beneficiario>{
  return this.http.get<any>(`http://localhost:8080/api/beneficiarios/${id}`);
  }

  deletar(beneficiario: Beneficiario) : Observable<any>{
    return this.http.delete<any>(`http://localhost:8080/api/beneficiarios/${beneficiario.id}`);
  }

}
