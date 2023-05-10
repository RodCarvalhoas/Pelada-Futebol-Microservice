package io.github.rodcarvalhoas.mspartida.clients;

import io.github.rodcarvalhoas.mspartida.model.UsuarioPartidaAdm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "msusuario", path = "/usuario") //Comunicação com o MSUsuario
public interface UsuarioPartidaAdmClient {

    @GetMapping(params = "cpf")
    UsuarioPartidaAdm getUsuarioByCpf(@RequestParam("cpf") String cpf);
}
