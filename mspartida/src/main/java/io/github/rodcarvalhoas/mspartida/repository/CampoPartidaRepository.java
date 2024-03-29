package io.github.rodcarvalhoas.mspartida.repository;

import io.github.rodcarvalhoas.mspartida.model.CampoPartida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CampoPartidaRepository extends JpaRepository <CampoPartida,Long> {

    Optional<CampoPartida> findBynomeCampo (String nomeCampo);
}
