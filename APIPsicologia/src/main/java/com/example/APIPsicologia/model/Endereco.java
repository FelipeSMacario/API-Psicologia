package com.example.APIPsicologia.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Estado estado;

    @ManyToOne
    private Cidade cidade;

    private String complemento;

    private String numero;
}
