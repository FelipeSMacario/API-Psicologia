package com.example.APIPsicologia.service;

import com.example.APIPsicologia.exceptions.*;
import com.example.APIPsicologia.model.Consulta;
import com.example.APIPsicologia.model.Paciente;
import com.example.APIPsicologia.model.Usuario;
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

    public ResponseEntity<?> createConsulta(@RequestBody Consulta consulta) {
        try {
            validaFinalDeSemana(consulta.getData());
            validHoraFuncionamento(consulta.getHora());
            horaDisponivel(consulta.getData(), consulta.getHora(), consulta.getUsuario(), consulta.getPaciente());

        } catch (FinalDeSemanaExceptions | ForaHorarioException | HorarioDisponivelException | PacienteHorarioException | PacienteUsuarioException fds) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fds.toString());
        }
        return new ResponseEntity<>(consultaRepository.save(consulta), HttpStatus.CREATED);
    }

    public List<Consulta> listarConsulta() {
        return consultaRepository.findAll();
    }

    public ResponseEntity<Consulta> findConsultaById(Long id) {
        return consultaRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity updateConsulta(@RequestBody Consulta consulta, Long id) {
        try {
            validaFinalDeSemana(consulta.getData());
            validHoraFuncionamento(consulta.getHora());

        } catch (FinalDeSemanaExceptions | ForaHorarioException fds) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fds.toString());
        }

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

    public ResponseEntity deleteConsulta(Long id) {
        return consultaRepository.findById(id)
                .map(record -> {
                    consultaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    public List<Consulta> findByData(LocalDate date, LocalTime hora) {
        return consultaRepository.ListarPorData(date, hora);
    }

    public static void validaFinalDeSemana(LocalDate data) throws FinalDeSemanaExceptions {
        if (data.getDayOfWeek() == DayOfWeek.SATURDAY || data.getDayOfWeek() == DayOfWeek.SUNDAY)
            throw new FinalDeSemanaExceptions();
    }

    public static void validHoraFuncionamento(LocalTime hora) throws ForaHorarioException {
        if (hora.isBefore(LocalTime.parse("09:00")) || hora.isAfter(LocalTime.parse("17:00")))
            throw new ForaHorarioException();
    }

    public void horaDisponivel(LocalDate data, LocalTime hora, Usuario usuario, Paciente paciente) throws PacienteUsuarioException, HorarioDisponivelException, PacienteHorarioException {
        if (consultaRepository.findByDataAndHoraAndUsuarioAndPaciente(data, hora, usuario, paciente).size() > 0)
            throw new PacienteUsuarioException();
        else if (consultaRepository.findByDataAndHoraAndUsuario(data, hora, usuario).size() > 0)
            throw new HorarioDisponivelException();
        else if (consultaRepository.findByDataAndHoraAndPaciente(data, hora, paciente).size() > 0)
            throw new PacienteHorarioException();
    }
}
