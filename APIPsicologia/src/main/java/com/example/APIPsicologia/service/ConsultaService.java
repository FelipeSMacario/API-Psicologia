package com.example.APIPsicologia.service;

import com.example.APIPsicologia.exceptions.FinalDeSemanaExceptions;
import com.example.APIPsicologia.exceptions.ForaHorarioException;
import com.example.APIPsicologia.model.Consulta;
import com.example.APIPsicologia.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    public ResponseEntity<?> createConsulta(@RequestBody Consulta consulta)  {
        try {
            if (consulta.getData().getDayOfWeek() == DayOfWeek.SATURDAY || consulta.getData().getDayOfWeek() == DayOfWeek.SUNDAY)
                throw new FinalDeSemanaExceptions();

            if (consulta.getHora().isBefore( LocalTime.parse("09:00")) || consulta.getHora().isAfter(LocalTime.parse("17:00")))
                throw new ForaHorarioException();

        } catch (FinalDeSemanaExceptions | ForaHorarioException fds ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fds.toString());
        }
        return new ResponseEntity<>(consultaRepository.save(consulta), HttpStatus.CREATED);
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

//    public List<Consulta> listarConsultaPorData(LocalDate data){
//        return consultaRepository.findByData(data);
//    }

    public List<Consulta> findByData(LocalDate date, LocalTime hora){
        return consultaRepository.ListarPorData(date, hora);
    }

    public void validaFinalDeSemana() {

    }
}
