import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Paciente } from '../model/paciente.model';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  url : string = "http://localhost:8080/paciente";

  constructor(private httpClient : HttpClient) { }

  listarPacientes() : Observable<Paciente[]>{
    return this.httpClient.get<Paciente[]>(`${this.url}`);
  }
}
