package com.example.APIPsicologia.model;


import com.example.APIPsicologia.enums.Genero;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer idade;

    private Double valor;

    private Genero genero;

    @ManyToOne
    private Endereco endereco;
}
