package com.example.APIPsicologia.controller;

import com.example.APIPsicologia.exceptions.FinalDeSemanaExceptions;
import com.example.APIPsicologia.model.Consulta;
import com.example.APIPsicologia.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("consulta")
public class ConsultaController {
    @Autowired
    ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<?> createConsulta(@RequestBody Consulta consulta) throws FinalDeSemanaExceptions {
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

    @GetMapping("/search")
    List<Consulta> findByData(@RequestParam("data") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam(value = "hora", required = false) LocalTime hora) {
        System.out.println(date.getDayOfWeek());
        return consultaService.findByData(date, hora);
    }
}
