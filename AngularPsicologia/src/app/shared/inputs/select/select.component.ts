import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Objeto } from './objeto.model';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css'],
})
export class SelectComponent implements OnInit {
  @Input() label: string;
  @Input() formGroup: FormGroup;
  @Input() ControlName: string;
  @Input() Objeto: Objeto[];
  @Output() modelo = new EventEmitter();

  constructor() {}

  atualizaModelo(e : any){  
    this.modelo.emit(e.value.id);
  }

  ngOnInit(): void {}
}
