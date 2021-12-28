package com.example.APIPsicologia.repository;

import com.example.APIPsicologia.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query(value = "SELECT * FROM psicologia.cidade WHERE estado_id = :id", nativeQuery = true)
    List<Cidade> filtraCidade(@Param("id") Long id);
}
