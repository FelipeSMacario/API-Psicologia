import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { take } from 'rxjs/operators';
import { Cidade } from '../model/cidade.model';
import { Estado } from '../model/estado.model';
import { CidadeService } from '../service/cidade.service';
import { EstadoService } from '../service/estado.service';

@Component({
  selector: 'app-psicologo',
  templateUrl: './psicologo.component.html',
  styleUrls: ['./psicologo.component.css']
})
export class PsicologoComponent implements OnInit {

  formulario : FormGroup;
  estados : Estado[] = [];
  cidade : Cidade[] = [];

  constructor(
    private fb : FormBuilder,
    private estadoService : EstadoService,
    private cidadeService : CidadeService
  ) { }

  ngOnInit(): void {
    this.listarEstados();
    this.formularioVazio();
  }

  formularioVazio(){
    this.formulario = this.fb.group({
      id : [null],
      estado : [null],
      cidade : [null]
    })
  }

  listarEstados() : void {
    this.estadoService.listarEstados().pipe(take(1)).subscribe({
      next : est => this.estados = est,
      error : err => console.log(err)
    })
  }

  listarCidade(e : any) : void {
    this.cidadeService.listarCidades(e).pipe(take(1)).subscribe({
      next : cid => this.cidade = cid,
      error : err => console.log(err)
    })
  }

  abc(){
    
    console.log(this.formulario.value)
  }

}
