package io.github.rodcarvalhoas.mspartida.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Partida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String nomePartida;
    private String descricaoPartida;
    private String cpfUsuarioPartidaAdm;
    private Integer qntJogadorPorTime;

    @OneToOne
    private CampoPartida campoPartida;

    @OneToMany(mappedBy = "partida")
    private List<JogadoresPartida> jogadores;





}
