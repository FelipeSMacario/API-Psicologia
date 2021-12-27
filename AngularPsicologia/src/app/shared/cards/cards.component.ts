import { Component, Input, OnInit } from '@angular/core';
import { Consulta } from 'src/app/model/consulta.model';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent implements OnInit {

  @Input() cards : Consulta[];

  constructor() { }

  ngOnInit(): void {
  }

}
