import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { take } from 'rxjs/operators';
import { Consulta } from '../model/consulta.model';
import { ConsultaService } from '../service/consulta.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  hoje : Date = new Date();

  consultas : Consulta[] = [];

  constructor(
    private consultaService : ConsultaService
  ) { }

  ngOnInit(): void {
    localStorage.setItem("usuarioValidado", JSON.stringify(true));
    this.consultasHoje();
  }

  emitirData(){
    var mes : any = this.hoje.getMonth()! + 1;
    var dia : any = this.hoje.getDate();
    mes >= 10 ? mes = mes.toString() : mes = "0" + mes;
    dia >= 10 ? dia = dia.toString() : dia = "0" + dia;
   console.log(this.hoje.getFullYear() + "-" + mes + "-"  +  dia); 
    console.log(this.hoje.getHours())    
  }

  consultasHoje(){
    var mes : any = this.hoje.getMonth()! + 1;
    var dia : any = this.hoje.getDate();
    mes >= 10 ? mes = mes.toString() : mes = "0" + mes;
    dia >= 10 ? dia = dia.toString() : dia = "0" + dia;


    let params = new HttpParams().set("data", this.hoje.getFullYear() + "-" + mes + "-"  +  dia)
    this.consultaService.filtrarConsultaporDate(params.toString()).pipe(take(1)).subscribe({
      next : consult => this.consultas = consult,
      error : err => console.log(err) 
    })
  }

}
