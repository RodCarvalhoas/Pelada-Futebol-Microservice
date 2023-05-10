package io.github.rodcarvalhoas.mspartida.repository;

import io.github.rodcarvalhoas.mspartida.model.JogadoresPartida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


public interface JogadoresPartidaRepository extends JpaRepository<JogadoresPartida, Long> {

    @GetMapping
    @Query("SELECT jp FROM JogadoresPartida jp WHERE jp.partida.id = :id")
    List<JogadoresPartida> findByJogadoresPartida(@Param("id") Long id);


}
