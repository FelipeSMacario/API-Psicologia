import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cidade } from '../model/cidade.model';

@Injectable({
  providedIn: 'root'
})
export class CidadeService {

  url : string = "http://localhost:8080/cidade";

  constructor(
    private httpClient : HttpClient
  ) { }

  listarCidades(id : number) : Observable<Cidade[]>{
    return this.httpClient.get<Cidade[]>(`${this.url}/${id}`);
  }
}
