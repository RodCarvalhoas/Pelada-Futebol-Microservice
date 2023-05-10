package io.github.rodcarvalhoas.mspartida.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_campo_partida")
public class CampoPartida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_campo_partida")
    private Long idCampoPartida;

    @Column(name = "nome_campo")
    private String nomeCampo;

    @Column(name = "localizacao_campo_partida")
    private String localizacaoCampoPartida;

}
