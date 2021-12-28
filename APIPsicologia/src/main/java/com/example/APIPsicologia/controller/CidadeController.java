package com.example.APIPsicologia.controller;

import com.example.APIPsicologia.model.Cidade;
import com.example.APIPsicologia.model.Estado;
import com.example.APIPsicologia.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("cidade")
public class CidadeController {
    @Autowired
    CidadeService cidadeService;

    @GetMapping("/{id}")
    public List<Cidade> listarCidade(@PathVariable Long id){
        return cidadeService.listarCidades(id);
    }
}
