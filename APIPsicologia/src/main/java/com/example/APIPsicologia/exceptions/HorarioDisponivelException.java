package com.example.APIPsicologia.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HorarioDisponivelException extends Exception{
    @Override
    public String toString(){
        return "Psicologo já vinculado em outra consulta nesse horário.";
    }
}
