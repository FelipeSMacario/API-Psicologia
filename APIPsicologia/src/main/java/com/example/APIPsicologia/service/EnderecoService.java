package com.example.APIPsicologia.service;

import com.example.APIPsicologia.model.Endereco;
import com.example.APIPsicologia.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    public Endereco createEndereco(@RequestBody Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEnderecos(){
        return enderecoRepository.findAll();
    }

    public ResponseEntity<Endereco> findEnderecoById(Long id){
        return enderecoRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity updateEndereco(@RequestBody Endereco endereco, Long id){
        return enderecoRepository.findById(id)
                .map(record -> {
                    record.setEstado(endereco.getEstado());
                    record.setCidade(endereco.getCidade());
                    record.setComplemento(endereco.getComplemento());
                    record.setNumero(endereco.getNumero());
                    Endereco update = enderecoRepository.save(record);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity deleteEndereco(Long id){
        return enderecoRepository.findById(id)
                .map(record -> {
                    enderecoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
