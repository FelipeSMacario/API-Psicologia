package com.example.APIPsicologia.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ForaHorarioException extends Exception{

    @Override
    public String toString(){
        return "Fora do horário do expediente que é de 09 às 18 horas";
    }
}
