package io.github.rodcarvalhoas.mspartida.dto;

import io.github.rodcarvalhoas.mspartida.model.JogadoresPartida;
import lombok.Data;

@Data
public class JogadoresPartidaDto {

    private Long id;
    private String nomeJogador;
    private Integer numeroCamisa;

    public JogadoresPartida toModel(JogadoresPartidaDto jogadoresPartidaDto){
        return JogadoresPartida
                .builder()
                .id(jogadoresPartidaDto.getId())
                .nomeJogador(jogadoresPartidaDto.getNomeJogador())
                .numeroCamisa(jogadoresPartidaDto.getNumeroCamisa())
                .build();
    }

}
