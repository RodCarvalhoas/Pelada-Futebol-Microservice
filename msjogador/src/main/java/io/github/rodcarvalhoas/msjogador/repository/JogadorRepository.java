package io.github.rodcarvalhoas.msjogador.repository;

import io.github.rodcarvalhoas.msjogador.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface JogadorRepository extends JpaRepository <Jogador, Long> {

}
