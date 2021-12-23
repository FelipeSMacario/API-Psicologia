package com.example.APIPsicologia.controller;

import com.example.APIPsicologia.model.Paciente;
import com.example.APIPsicologia.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("paciente")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public Paciente createPaciente(@RequestBody Paciente paciente){
        return pacienteService.createPaciente(paciente);
    }

    @GetMapping
    public List<Paciente> listarPacientes(){
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findPacienteById(@PathVariable Long id){
        return pacienteService.findPacienteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePaciente(@RequestBody Paciente paciente, @PathVariable Long id){
        return pacienteService.updatePaciente(paciente, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePaciente(@PathVariable Long id){
        return pacienteService.deletePaciente(id);
    }
}
