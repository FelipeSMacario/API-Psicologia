package com.example.APIPsicologia.service;

import com.example.APIPsicologia.model.Consulta;
import com.example.APIPsicologia.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    ConsultaRepository consultaRepository;

    public Consulta createConsulta(@RequestBody Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsulta(){
        return consultaRepository.findAll();
    }

    public ResponseEntity<Consulta> findConsultaById(Long id){
        return consultaRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity updateConsulta(@RequestBody Consulta consulta, Long id){
        return consultaRepository.findById(id)
                .map(record -> {
                    record.setUsuario(consulta.getUsuario());
                    record.setPaciente(consulta.getPaciente());
                    record.setData(consulta.getData());
                    record.setHora(consulta.getHora());
                    Consulta update = consultaRepository.save(record);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity deleteConsulta(Long id){
        return consultaRepository.findById(id)
                .map(record -> {
                    consultaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


}
