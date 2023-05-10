package io.github.rodcarvalhoas.mspartida.clients;

import io.github.rodcarvalhoas.mspartida.dto.JogadoresPartidaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "msjogador", path = "/jogador") //Comunicação com o MSJogador
public interface JogadoresPartidaDtoClient {

    @GetMapping(params = "{id}")
    JogadoresPartidaDto findById(@RequestParam("id") Long id);
}
