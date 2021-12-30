import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../model/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  url : string = "http://localhost:8080/usuario";

  constructor(
    private httpClient : HttpClient
  ) { }

  listarUsuario() : Observable<Usuario[]> {
    return this.httpClient.get<Usuario[]>(`${this.url}`);
  }
}
