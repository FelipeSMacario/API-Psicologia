import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Consulta } from '../model/consulta.model';

@Injectable({
  providedIn: 'root'
})
export class ConsultaService {

  url : string = "http://localhost:8080/consulta";

  constructor(private httpClient : HttpClient) { }

  listarConsultas() : Observable<Consulta[]> {
    return this.httpClient.get<Consulta[]>(`${this.url}`);
  }
}
