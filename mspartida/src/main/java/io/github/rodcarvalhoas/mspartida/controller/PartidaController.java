package io.github.rodcarvalhoas.mspartida.controller;

import io.github.rodcarvalhoas.mspartida.dto.PartidaDto;
import io.github.rodcarvalhoas.mspartida.dto.PartidaSorteadaResponse;
import io.github.rodcarvalhoas.mspartida.exception.ResourceNotFoundException;
import io.github.rodcarvalhoas.mspartida.model.Partida;
import io.github.rodcarvalhoas.mspartida.service.PartidaService;
import io.github.rodcarvalhoas.mspartida.service.SorteadorDeTimesService;
import io.github.rodcarvalhoas.mspartida.service.UsuarioPartidaAdmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;

@RestController
@RequestMapping("/partida")
@RequiredArgsConstructor
public class PartidaController implements Serializable {

    private final PartidaService partidaService;
    private final UsuarioPartidaAdmService usuarioPartidaAdmService;
    private final SorteadorDeTimesService sorteadorDeTimesService;

    @PostMapping(value = "/criar-partida", params = {"cpf", "idCampoPartida"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long criarPartida(@RequestParam String cpf, Long idCampoPartida,
                                @Valid @RequestBody PartidaDto partidaDto){


        Long partidaId = partidaService.criarPartida(cpf,idCampoPartida, partidaDto);
        return partidaId;
    }

    @GetMapping(value = "/visualizar-partida", params = "id")
    @ResponseStatus(HttpStatus.OK)
    public Partida verPartida(@RequestParam Long id){
        return partidaService.verPartida(id);
    }


   @PostMapping(value = "/jogadores-partida", params = {"idPartida", "idPartidaJogador"})
   @ResponseStatus(HttpStatus.OK)
    public void inserirJogadorPartida(@RequestParam Long idPartida, Long idPartidaJogador) throws ResourceNotFoundException {
        partidaService.inserirJogadorPartida(idPartida, idPartidaJogador);
   }

   @GetMapping(value = "/sortear-times", params = "id")
   @ResponseStatus(HttpStatus.OK)
    public PartidaSorteadaResponse sortearTimes(@RequestParam Long id){
        return sorteadorDeTimesService.sortearTimes(id);
   }


}
