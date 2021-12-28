package com.example.APIPsicologia.service;

import com.example.APIPsicologia.model.Cidade;
import com.example.APIPsicologia.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {
    @Autowired
    CidadeRepository cidadeRepository;

    public List<Cidade> listarCidades(Long id){
        return cidadeRepository.filtraCidade(id);
    }
}
