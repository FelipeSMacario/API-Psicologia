import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  hoje : Date = new Date();

  constructor() { }

  ngOnInit(): void {
    localStorage.setItem("usuarioValidado", JSON.stringify(true));
    this.emitirData();
  }

  emitirData(){
    var mes : any = this.hoje.getMonth()! + 1;
    var dia : any = this.hoje.getDate();
    mes >= 10 ? mes = mes.toString() : mes = "0" + mes;
    dia >= 10 ? dia = dia.toString() : dia = "0" + dia;
   console.log(this.hoje.getFullYear() + "-" + mes + "-"  +  dia); 
    console.log(this.hoje.getHours())
    
  }

}
