package io.github.rodcarvalhoas.mspartida.controller;

import io.github.rodcarvalhoas.mspartida.model.CampoPartida;
import io.github.rodcarvalhoas.mspartida.service.CampoPartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campo")
@RequiredArgsConstructor
public class CampoPartidaController {

    private final CampoPartidaService campoPartidaService;

    @PostMapping(value = "/salvar-campo")
    @ResponseStatus(HttpStatus.CREATED)
    public Long salvarCampo(@RequestBody CampoPartida campoPartida){
        return campoPartidaService.salvarCampo(campoPartida);
    }

    @GetMapping(value = "/visualizar-campos")
    @ResponseStatus(HttpStatus.OK)
    public List<CampoPartida> visualizarCampos(){
        return campoPartidaService.visualizarCampos();
    }

}
