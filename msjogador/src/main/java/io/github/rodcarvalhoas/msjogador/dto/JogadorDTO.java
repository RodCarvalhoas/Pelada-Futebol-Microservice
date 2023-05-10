package io.github.rodcarvalhoas.msjogador.dto;

import io.github.rodcarvalhoas.msjogador.model.Jogador;
import lombok.Data;

@Data
public class JogadorDTO {
    private String nomeJogador;
    private Integer numeroCamisa;

    public Jogador toModel(JogadorDTO jogadorDTO){
        return Jogador
                .builder()
                .nomeJogador(jogadorDTO.getNomeJogador())
                .numeroCamisa(jogadorDTO.getNumeroCamisa())
                .build();
    }
}
