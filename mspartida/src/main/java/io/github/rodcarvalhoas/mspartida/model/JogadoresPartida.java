package io.github.rodcarvalhoas.mspartida.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Jogadores_Partida")
public class JogadoresPartida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeJogador;
    private Integer numeroCamisa;

    @JsonIgnore
    @ManyToOne
    private Partida partida;

}
