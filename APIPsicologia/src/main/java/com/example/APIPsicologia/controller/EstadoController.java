package com.example.APIPsicologia.controller;

import com.example.APIPsicologia.model.Estado;
import com.example.APIPsicologia.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("estado")
public class EstadoController {

    @Autowired
    EstadoService estadoService;

    @GetMapping
    public List<Estado> listarEstados(){
        return estadoService.listarEstados();
    }
}
