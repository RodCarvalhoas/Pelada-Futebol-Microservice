package io.github.rodcarvalhoas.mspartida.service;

import io.github.rodcarvalhoas.mspartida.model.JogadoresPartida;
import io.github.rodcarvalhoas.mspartida.repository.JogadoresPartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JogadoresPartidaService {

    @Autowired
    private JogadoresPartidaRepository jogadoresPartidaRepository;

    public Optional<JogadoresPartida> getById(Long id){
        return jogadoresPartidaRepository.findById(id);
    }

}
