import { Time } from "@angular/common";
import { Paciente } from "./paciente.model";
import { Usuario } from "./usuario.model";

export class Consulta {
    id : number;
    paciente : Paciente;
    usuario : Usuario;
    data : Date;
    hora : Time
}