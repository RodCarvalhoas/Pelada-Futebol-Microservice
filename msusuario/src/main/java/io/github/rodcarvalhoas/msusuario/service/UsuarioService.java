package io.github.rodcarvalhoas.msusuario.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.rodcarvalhoas.msusuario.dto.UsuarioDTO;
import io.github.rodcarvalhoas.msusuario.model.Usuario;
import io.github.rodcarvalhoas.msusuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Optional<Usuario> getUsuarioByCPF(String cpf){
        Optional<Usuario> usuarioOptional = usuarioRepository.findBycpf(cpf);
        if(usuarioOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
        return usuarioOptional;
    }

    public void saveUsuario(Usuario usuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findBycpf(usuario.getCpf());
        if(usuarioOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT ,"Usuário com cpf já cadastrado");
        }
        usuarioRepository.save(usuario);
    }

    public void deleteUsuario(String cpf){
        Optional<Usuario> usuarioOptional = usuarioRepository.findBycpf(cpf);
        if(usuarioOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
        usuarioRepository.delete(usuarioOptional.get());
    }

  }
