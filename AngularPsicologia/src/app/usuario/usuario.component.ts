import { Component, OnInit } from '@angular/core';
import { take } from 'rxjs/operators';
import { Consulta } from '../model/consulta.model';
import { ConsultaService } from '../service/consulta.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

consultas : Consulta[] = [];

  constructor(
    private consultaService : ConsultaService
    ) { }

  ngOnInit(): void {
    this.listarConsultas();
  }

  listarConsultas() {
    this.consultaService.listarConsultas().pipe(take(1)).subscribe({
      next : consult => this.consultas = consult,
      error : err => console.log(err)
    })
  }  

}
