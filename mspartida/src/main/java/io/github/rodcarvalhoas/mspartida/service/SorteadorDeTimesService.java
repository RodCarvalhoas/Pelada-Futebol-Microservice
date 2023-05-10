package io.github.rodcarvalhoas.mspartida.service;

import io.github.rodcarvalhoas.mspartida.dto.PartidaSorteadaResponse;
import io.github.rodcarvalhoas.mspartida.model.JogadoresPartida;
import io.github.rodcarvalhoas.mspartida.model.Partida;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SorteadorDeTimesService {

    private final PartidaService partidaService;

    //Metodo para sortear os times
    public PartidaSorteadaResponse sortearTimes(Long id){
        Partida partida = partidaService.verPartida(id);
        PartidaSorteadaResponse partidaSorteadaResponse = new PartidaSorteadaResponse();
        partidaSorteadaResponse.setNomePartida(partida.getNomePartida());
        partidaSorteadaResponse.setDescricaoPartida(partida.getDescricaoPartida());
        partidaSorteadaResponse.setCampoPartida(partida.getCampoPartida());
        partidaSorteadaResponse.setQntJogadorPorTime(partida.getQntJogadorPorTime());

        if(partida.getJogadores().size() == partida.getQntJogadorPorTime() * 2){
            List<JogadoresPartida> jogadores = partida.getJogadores();
            Collections.shuffle(jogadores);
            List<JogadoresPartida> timeA = jogadores.subList(0, (partida.getQntJogadorPorTime() * 2) / 2);
            List<JogadoresPartida> timeB = jogadores.subList((partida.getQntJogadorPorTime() * 2) / 2, partida.getQntJogadorPorTime() * 2);
            partidaSorteadaResponse.setTimeA(timeA);
            partidaSorteadaResponse.setTimeB(timeB);

        }else{
            throw new RuntimeException("Quantidade de jogadores insuficientes para o sorteamento dos times.");
        }
        return  partidaSorteadaResponse;
    }


}
