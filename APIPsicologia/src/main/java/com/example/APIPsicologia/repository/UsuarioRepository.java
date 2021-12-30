package com.example.APIPsicologia.repository;

import com.example.APIPsicologia.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM psicologia.usuario WHERE endereco_id IN (SELECT id FROM psicologia.endereco WHERE estado_id " +
            "IN (SELECT id FROM psicologia.estado WHERE nome = IFNULL (:estado, nome)) AND cidade_id IN (SELECT id FROM psicologia.cidade WHERE nome = IFNULL(:cidade, nome)))" +
            "AND idade between IFNULL(:idadeInicio, idade) AND IFNULL(:IdadeFim, idade)", nativeQuery = true)
    List<Usuario> filtrarUsuario(@Param("estado") String estado,
                                 @Param("cidade") String cidade,
                                 @Param("idadeInicio") Integer idadeInicio,
                                 @Param("IdadeFim") Integer idadeFim);



}
