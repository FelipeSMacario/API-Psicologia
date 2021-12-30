import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { take } from 'rxjs/operators';
import { Cidade } from '../model/cidade.model';
import { Estado } from '../model/estado.model';
import { Usuario } from '../model/usuario.model';
import { CidadeService } from '../service/cidade.service';
import { EstadoService } from '../service/estado.service';
import { UsuarioService } from '../service/usuario.service';

@Component({
  selector: 'app-psicologo',
  templateUrl: './psicologo.component.html',
  styleUrls: ['./psicologo.component.css']
})
export class PsicologoComponent implements OnInit {

  formulario : FormGroup;
  estados : Estado[] = [];
  cidade : Cidade[] = [];
  usuarios : Usuario[] = [];

  constructor(
    private fb : FormBuilder,
    private estadoService : EstadoService,
    private cidadeService : CidadeService,
    private usuarioService : UsuarioService
  ) { }

  ngOnInit(): void {
    this.listarEstados();
    this.formularioVazio();
  }

  formularioVazio(){
    this.formulario = this.fb.group({
      id : [null],
      estado : [null],
      cidade : [null],
      genero : [null],
      idade : [null]
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

  listarUsuarios() : void {
    this.usuarioService.listarUsuario().pipe(take(1)).subscribe({
      next : usu => this.usuarios = usu,
      error : err => console.log(err)
    })
  }

  abc(){
    let valorIdade : number = parseInt(this.formulario.value.idade);
    this.filtrarIdade(valorIdade);    
  }

  filtrarIdade(idade? : number) {
    switch(idade){
      case 20 : {
        console.log("between 20");
        break;
      }
      case 30 : {
        console.log("between 30");
        break;
      }
      case 40 : {
        console.log("between 40");
        break;
      }
    }
  }

}
