import { Endereco } from "./endereco.model";
import { Usuario } from "./usuario.model";

export class Paciente {
    id : number;
    nome : string;
    endereco : Endereco;
    usuario : Usuario;
    foto : string;
}