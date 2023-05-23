package io.github.rodcarvalhoas.mspartida.service;

import io.github.rodcarvalhoas.mspartida.exception.ResourceNotFoundException;
import io.github.rodcarvalhoas.mspartida.model.UsuarioPartidaAdm;
import io.github.rodcarvalhoas.mspartida.clients.UsuarioPartidaAdmClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsuarioPartidaAdmService {

    @Autowired
    private UsuarioPartidaAdmClient usuarioPartidaAdmClient;

    public UsuarioPartidaAdm getUsuario(String cpf){
        Optional<UsuarioPartidaAdm> usuarioPartidaAdmOptional = usuarioPartidaAdmClient.getUsuarioByCpf(cpf);
        if(usuarioPartidaAdmOptional.isEmpty()){
            throw new ResourceNotFoundException("Usuario Adm não encontrado");
        }
        return usuarioPartidaAdmOptional.get();
    }
}
