package com.example.APIPsicologia.service;

import com.example.APIPsicologia.model.Paciente;
import com.example.APIPsicologia.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    public Paciente createPaciente(@RequestBody Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    }

    public ResponseEntity<Paciente> findPacienteById(Long id){
        return pacienteRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity updatePaciente(@RequestBody Paciente paciente, Long id){
        return pacienteRepository.findById(id)
                .map(record -> {
                    record.setNome(paciente.getNome());
                    record.setUsuario(paciente.getUsuario());
                    record.setEndereco(paciente.getEndereco());
                    Paciente update = pacienteRepository.save(record);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity deletePaciente(Long id){
        return pacienteRepository.findById(id)
                .map(record -> {
                    pacienteRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
