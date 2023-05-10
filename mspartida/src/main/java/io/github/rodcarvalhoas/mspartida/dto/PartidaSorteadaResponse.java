package io.github.rodcarvalhoas.mspartida.dto;

import io.github.rodcarvalhoas.mspartida.model.CampoPartida;
import io.github.rodcarvalhoas.mspartida.model.JogadoresPartida;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PartidaSorteadaResponse {

    private String nomePartida;
    private String descricaoPartida;
    private Integer qntJogadorPorTime;
    private CampoPartida campoPartida;

    private List<JogadoresPartida> timeA;
    private List<JogadoresPartida> timeB;
}
