package com.example.APIPsicologia.repository;

import com.example.APIPsicologia.model.Consulta;
import com.example.APIPsicologia.model.Paciente;
import com.example.APIPsicologia.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    @Query(value = "SELECT * FROM psicologia.consulta WHERE data = :date and hora >= IFNULL (:hora,hora) order by hora", nativeQuery = true)
    List<Consulta> ListarPorData(@Param("date") LocalDate date, @Param("hora") LocalTime hora);

    List<Consulta> findByDataAndHoraAndUsuarioAndPaciente(LocalDate data, LocalTime hora, Usuario usuario, Paciente paciente);

    List<Consulta> findByDataAndHoraAndUsuario(LocalDate data, LocalTime hora, Usuario usuario);

    List<Consulta> findByDataAndHoraAndPaciente(LocalDate data, LocalTime hora, Paciente paciente);
}
