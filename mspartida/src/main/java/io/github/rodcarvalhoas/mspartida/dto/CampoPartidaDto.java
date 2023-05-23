package io.github.rodcarvalhoas.mspartida.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CampoPartidaDto {

    @NotBlank(message = "O campo nome do campo não pode estar vazio")
    private String nomeCampo;

    @NotBlank(message = "Deve ser inserido uma localização para o campo da partida")
    private String localizacaoCampoPartida;
}
