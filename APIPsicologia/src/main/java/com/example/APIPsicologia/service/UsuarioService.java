package com.example.APIPsicologia.service;

import com.example.APIPsicologia.model.Usuario;
import com.example.APIPsicologia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuario(){
        return usuarioRepository.findAll();
    }

    public ResponseEntity<Usuario> findUsuarioById(Long id){
        return usuarioRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity updateUsuario(@RequestBody Usuario usuario, Long id){
        return usuarioRepository.findById(id)
                .map(record -> {
                    record.setNome(usuario.getNome());
                    record.setEndereco(usuario.getEndereco());
                    Usuario update = usuarioRepository.save(record);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity deleteUsuario(Long id){
        return usuarioRepository.findById(id)
                .map(record -> {
                    usuarioRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
