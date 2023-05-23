package io.github.rodcarvalhoas.mspartida.dto;

import io.github.rodcarvalhoas.mspartida.model.CampoPartida;
import io.github.rodcarvalhoas.mspartida.model.JogadoresPartida;
import io.github.rodcarvalhoas.mspartida.model.Partida;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PartidaDto {

    private Long id;

    @NotBlank(message = "O campo nome da partida não pode ser vazio")
    private String nomePartida;

    private String descricaoPartida;

    @NotNull(message = "A quantidade de jogadores não pode ser vazio")
    @Max(value = 11, message = "A quantidade de jogadores deve ser entre 3 a 11 por time")
    @Min(value = 3, message = "A quantidade de jogadores deve ser entre 3 a 11 por time")
    private Integer qntJogadorPorTime;

    private String cpfUsuarioPartidaAdm;

    private List<JogadoresPartida> jogadoresPartidas;

    private CampoPartida campoPartida;

    public Partida toModel(PartidaDto partidaDto){
        return Partida
                .builder()
                .nomePartida(partidaDto.getNomePartida())
                .descricaoPartida(partidaDto.getDescricaoPartida())
                .qntJogadorPorTime(partidaDto.getQntJogadorPorTime())
                .cpfUsuarioPartidaAdm(partidaDto.getCpfUsuarioPartidaAdm())
                .campoPartida(partidaDto.getCampoPartida())
                .build();
    }

}
