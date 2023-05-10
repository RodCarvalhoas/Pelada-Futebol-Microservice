package io.github.rodcarvalhoas.mspartida.service;

import io.github.rodcarvalhoas.mspartida.model.UsuarioPartidaAdm;
import io.github.rodcarvalhoas.mspartida.clients.UsuarioPartidaAdmClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioPartidaAdmService {

    @Autowired
    private UsuarioPartidaAdmClient usuarioPartidaAdmClient;

    public UsuarioPartidaAdm getUsuario(String cpf){
        UsuarioPartidaAdm usuario = usuarioPartidaAdmClient.getUsuarioByCpf(cpf);
        return usuario;
    }

}
