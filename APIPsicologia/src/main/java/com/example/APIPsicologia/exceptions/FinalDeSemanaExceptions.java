package com.example.APIPsicologia.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FinalDeSemanaExceptions extends Exception{

    @Override
    public String toString(){
        return "Não é permitida a inclusão de consultas em finais de semana";
    }


}
