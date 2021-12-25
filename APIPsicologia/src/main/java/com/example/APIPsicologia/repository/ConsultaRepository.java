package com.example.APIPsicologia.repository;

import com.example.APIPsicologia.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    @Query(value = "SELECT * FROM psicologia.consulta WHERE data = :date  order by hora", nativeQuery = true)
    List<Consulta> ListarPorData(@Param("date") LocalDate date);
}
