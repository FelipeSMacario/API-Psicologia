import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { take } from 'rxjs/operators';
import { Consulta } from '../model/consulta.model';
import { ConsultaService } from '../service/consulta.service';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.css']
})
export class PacienteComponent implements OnInit {

  consultas : Consulta[] = [];

  constructor(
    private consultaService : ConsultaService
  ) { }

  ngOnInit(): void {
    this.listarConsultas();
  }

  listarConsultas(){
    this.consultaService.listarConsultas().pipe(take(1)).subscribe({
      next : consult => this.consultas = consult,
      error : err => console.log(err)
    })
  }

  filtrarData(event : any){
    let params = new HttpParams().set("data", event );
    this.consultaService.filtrarConsultaporDate(params.toString()).pipe(take(1)).subscribe({
      next : consult => this.consultas = consult,
      error : err => console.log(err)
    })
  }

}
