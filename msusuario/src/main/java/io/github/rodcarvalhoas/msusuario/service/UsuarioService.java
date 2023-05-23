package io.github.rodcarvalhoas.msusuario.service;

import io.github.rodcarvalhoas.msusuario.exceptions.ResourceNotFoundException;
import io.github.rodcarvalhoas.msusuario.model.Usuario;
import io.github.rodcarvalhoas.msusuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Optional<Usuario> getUsuarioByCPF(String cpf){
        Optional<Usuario> usuarioOptional = usuarioRepository.findBycpf(cpf);
        usuarioOptional.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
        return usuarioOptional;
    }

    public void saveUsuario(Usuario usuario) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findBycpf(usuario.getCpf());
        if (usuarioOptional.isPresent()) {
            throw new ResourceNotFoundException("Usuário com cpf já cadastrado");
        }

        Optional<Usuario> usuarioPorEmail = usuarioRepository.findByemail(usuario.getEmail());
        if (usuarioPorEmail.isPresent()) {
            throw new ResourceNotFoundException("Email já está em uso");
        }

        usuarioRepository.save(usuario);
    }

    public void deleteUsuario(String cpf){
        Optional<Usuario> usuarioOptional = usuarioRepository.findBycpf(cpf);
        if(usuarioOptional.isEmpty()){
            throw new ResourceNotFoundException("Usuário não encontrado");
        }
        usuarioRepository.delete(usuarioOptional.get());
    }

  }
