package io.github.rodcarvalhoas.msjogador.controller;

import io.github.rodcarvalhoas.msjogador.dto.JogadorDTO;
import io.github.rodcarvalhoas.msjogador.model.Jogador;
import io.github.rodcarvalhoas.msjogador.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long criarJogador(@RequestBody @Valid JogadorDTO jogadorDTO){
        Jogador jogador = jogadorDTO.toModel(jogadorDTO);
        jogadorService.criarJogador(jogador);
        return jogador.getId();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Jogador> getAllJogador(){
        return jogadorService.getAllJogador();
    }

    @GetMapping(params = "id")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Jogador> findById(@RequestParam("id") Long id){
        return jogadorService.findById(id);
    }


}
