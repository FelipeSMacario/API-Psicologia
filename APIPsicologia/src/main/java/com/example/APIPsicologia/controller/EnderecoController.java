package com.example.APIPsicologia.controller;

import com.example.APIPsicologia.model.Endereco;
import com.example.APIPsicologia.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("endereco")
public class EnderecoController {
    @Autowired
    EnderecoService enderecoService;

    @PostMapping
    public Endereco createEndereco(@RequestBody Endereco endereco){
        return enderecoService.createEndereco(endereco);
    }

    @GetMapping
    public List<Endereco> listarEnderecos(){
        return enderecoService.listarEnderecos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findEnderecoById(@PathVariable Long id){
        return enderecoService.findEnderecoById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateEndereco(@RequestBody Endereco endereco, @PathVariable Long id){
        return enderecoService.updateEndereco(endereco, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEndereco(@PathVariable Long id){
        return enderecoService.deleteEndereco(id);
    }
}
