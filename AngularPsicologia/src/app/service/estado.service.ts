import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Estado } from '../model/estado.model';

@Injectable({
  providedIn: 'root'
})
export class EstadoService {

  url : string = "http://localhost:8080/estado";

  constructor(
    private httpClient : HttpClient
  ) { }

  listarEstados() : Observable<Estado[]>{
    return this.httpClient.get<Estado[]>(`${this.url}`);
  }
}
