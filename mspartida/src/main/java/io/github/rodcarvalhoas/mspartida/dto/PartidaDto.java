package io.github.rodcarvalhoas.mspartida.dto;

import com.sun.istack.NotNull;
import io.github.rodcarvalhoas.mspartida.model.CampoPartida;
import io.github.rodcarvalhoas.mspartida.model.JogadoresPartida;
import io.github.rodcarvalhoas.mspartida.model.Partida;
import lombok.Data;
import java.util.List;

@Data
public class PartidaDto {

    private Long id;

    @NotNull
    private String nomePartida;

    private String descricaoPartida;

    @NotNull
    private Integer qntJogadorPorTime;

    @NotNull
    private String cpfUsuarioPartidaAdm;

    private List<JogadoresPartida> jogadoresPartidas;

    @NotNull
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
