package io.github.rodcarvalhoas.msjogador.dto;

import io.github.rodcarvalhoas.msjogador.model.Jogador;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class JogadorDTO {

    @NotNull(message = "O nome do jogador não pode ser vazio")
    private String nomeJogador;

    @NotNull(message = "O n° do jogador não pode ser vazio")
    @Min(value = 1,message = "O numero da camisa deverá ser entre 1 e 99")
    @Max(value = 99, message = "O numero da camisa deverá ser entre 1 e 99")
    private Integer numeroCamisa;

    public Jogador toModel(JogadorDTO jogadorDTO){
        return Jogador
                .builder()
                .nomeJogador(jogadorDTO.getNomeJogador())
                .numeroCamisa(jogadorDTO.getNumeroCamisa())
                .build();
    }
}
