package io.github.rodcarvalhoas.msjogador.service;

import io.github.rodcarvalhoas.msjogador.model.Jogador;
import io.github.rodcarvalhoas.msjogador.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogador criarJogador(Jogador jogador){
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> getAllJogador(){
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> findById(Long id){
        return jogadorRepository.findById(id);
    }

}
