import { Cidade } from "./cidade.model";
import { Estado } from "./estado.model";

export class Endereco {
    id : number;
    estado : Estado;
    cidade : Cidade;
    complemento : string;
    numero : string;
}