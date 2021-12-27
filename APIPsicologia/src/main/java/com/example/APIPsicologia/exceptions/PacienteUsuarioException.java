package com.example.APIPsicologia.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PacienteUsuarioException extends Exception{
    @Override
    public String toString (){
        return "Paciente e psicologo já estão com consulta marcada para o horário solicitado.";
    }
}
