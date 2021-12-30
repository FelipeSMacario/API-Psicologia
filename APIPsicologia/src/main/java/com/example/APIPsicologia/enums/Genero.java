package com.example.APIPsicologia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genero {
    Masculino("Masculino"), Feminino("Feminino");

    private final String description;
}
