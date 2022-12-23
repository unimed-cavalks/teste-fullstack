import { PlanoBusca } from './plano/PlanoBusca';
import { Observable } from 'rxjs';
import { Plano } from './plano/Plano';
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PlanoService {

  apiUrl: string = environment.apiUrlBase + `/api/plano`;
  constructor(private http: HttpClient) { }

  salvar(servico: Plano) : Observable<Plano>{
      return this.http.post<Plano>(`${this.apiUrl}`, servico);
  }

  deletePlano(plano: Plano) : Observable<any>{
    return this.http.delete<any>(`${this.apiUrl}/${plano.id}`);
  }

  getPlanoById(id: number) : Observable<Plano>{
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  updatePlano(plano: Plano)  : Observable<any>{
    return this.http.put<Plano>(`${this.apiUrl}/${plano.id}`, plano);
  }


  buscar(params?: any) : Observable<PlanoBusca[]>{
    const url = this.apiUrl;
    let httpParams = new HttpParams();
    for (const key in params) {
      if (params.hasOwnProperty(key) && params[key]) {
        httpParams = httpParams.append(key, params[key].toString());
      }
    }
    console.log(params);
    console.log("URL", url);
    return this.http.get<any>(url, { params: httpParams });

   
    
  }
}
