package com.example.APIPsicologia.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PacienteHorarioException extends Exception{
    @Override
    public String toString(){
        return "Paciente já está cadastrado com outro psicologo";
    }
}
