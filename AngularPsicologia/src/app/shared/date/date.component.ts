import { Component, EventEmitter, OnInit, Output } from '@angular/core';


@Component({
  selector: 'app-date',
  templateUrl: './date.component.html',
  styleUrls: ['./date.component.css']
})
export class DateComponent implements OnInit {

  @Output() calendario = new EventEmitter();

  selected: Date | null;

  constructor() { }

  ngOnInit(): void {
 
  }

  emitirData(){
    var mes : any = this.selected?.getMonth()! + 1;
    var dia : any = this.selected?.getDate();
    mes >= 10 ? mes = mes.toString() : mes = "0" + mes;
    dia >= 10 ? dia = dia.toString() : dia = "0" + dia;
    this.calendario.emit(this.selected?.getFullYear() + "-" + mes + "-"  +  dia);    
    
    
  }

}
