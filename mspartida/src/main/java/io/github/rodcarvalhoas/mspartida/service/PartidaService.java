package io.github.rodcarvalhoas.mspartida.service;

import io.github.rodcarvalhoas.mspartida.dto.JogadoresPartidaDto;
import io.github.rodcarvalhoas.mspartida.dto.PartidaDto;
import io.github.rodcarvalhoas.mspartida.exception.JogadorPartidaNotFoundException;
import io.github.rodcarvalhoas.mspartida.exception.PartidaCriacaoException;
import io.github.rodcarvalhoas.mspartida.exception.PartidaNotFoundException;
import io.github.rodcarvalhoas.mspartida.model.*;
import io.github.rodcarvalhoas.mspartida.repository.CampoPartidaRepository;
import io.github.rodcarvalhoas.mspartida.clients.JogadoresPartidaDtoClient;
import io.github.rodcarvalhoas.mspartida.repository.JogadoresPartidaRepository;
import io.github.rodcarvalhoas.mspartida.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;
    @Autowired
    private CampoPartidaRepository campoPartidaRepository;
    @Autowired
    private UsuarioPartidaAdmService usuarioPartidaAdmService;
    @Autowired
    private JogadoresPartidaDtoClient jogadoresPartidaDtoClient;
    @Autowired
    private JogadoresPartidaRepository jogadoresPartidaRepository;

    @Transactional
    public Long criarPartida(String cpf,Long idCampoPartida,PartidaDto partidaDto){
        try{
            UsuarioPartidaAdm usuarioPartida = usuarioPartidaAdmService.getUsuario(cpf);
            CampoPartida campoPartida = campoPartidaRepository.getById(idCampoPartida);
            Partida partida = Partida
                    .builder()
                    .nomePartida(partidaDto.getNomePartida())
                    .descricaoPartida(partidaDto.getDescricaoPartida())
                    .qntJogadorPorTime(partidaDto.getQntJogadorPorTime())
                    .campoPartida(campoPartida)
                    .cpfUsuarioPartidaAdm(usuarioPartida.getCpf())
                    .build();

            partidaRepository.save(partida);
            return partida.getId();

        }catch (PartidaCriacaoException e){
            throw new PartidaCriacaoException("Erro ao criar a partida: " + e.getMessage());
        }
    }

    public Partida verPartida(Long id){
            Optional<Partida> partida = partidaRepository.findById(id);
            return partida.orElseThrow(() -> new PartidaNotFoundException("Partida não encontrada!"));
    }

    @Transactional
    public void inserirJogadorPartida(Long idPartida, Long idJogador) throws JogadorPartidaNotFoundException {
        Optional<Partida> partida = partidaRepository.findById(idPartida);
        if(partida.isEmpty()){
            throw new PartidaNotFoundException("Partida não encontrada!");
        }

        JogadoresPartidaDto jogadoresPartidaDto = jogadoresPartidaDtoClient.findById(idJogador);
        if(jogadoresPartidaDto == null){
            throw new JogadorPartidaNotFoundException("Jogador não encontrado!");
        }
        JogadoresPartida jogadoresPartida = jogadoresPartidaDto.toModel(jogadoresPartidaDto);
        jogadoresPartida.setPartida(partida.get());
        jogadoresPartidaRepository.save(jogadoresPartida);

    }
}
