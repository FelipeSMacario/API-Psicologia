package com.example.APIPsicologia.controller;

import com.example.APIPsicologia.model.Consulta;
import com.example.APIPsicologia.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("consulta")
public class ConsultaController {
    @Autowired
    ConsultaService consultaService;

    @PostMapping
    public Consulta createConsulta(@RequestBody Consulta consulta){
        return consultaService.createConsulta(consulta);
    }

    @GetMapping
    public List<Consulta> listarConsulta(){
        return consultaService.listarConsulta();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> findConsultaById(@PathVariable Long id){
        return consultaService.findConsultaById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateConsulta(@RequestBody Consulta consulta, @PathVariable Long id){
        return consultaService.updateConsulta(consulta, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteConsulta(@PathVariable Long id){
        return consultaService.deleteConsulta(id);
    }
}
