package io.github.rodcarvalhoas.mspartida.service;

import io.github.rodcarvalhoas.mspartida.exception.CampoPartidaCriacaoException;
import io.github.rodcarvalhoas.mspartida.model.CampoPartida;
import io.github.rodcarvalhoas.mspartida.repository.CampoPartidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampoPartidaService {

    private final CampoPartidaRepository campoPartidaRepository;

    public Long salvarCampo(CampoPartida campoPartida){
        try {
            campoPartidaRepository.save(campoPartida);
            return campoPartida.getIdCampoPartida();
        }catch (CampoPartidaCriacaoException e){
            throw new CampoPartidaCriacaoException("O campo não conseguiu ser criado");
        }
    }

    public List<CampoPartida> visualizarCampos(){
        return campoPartidaRepository.findAll();
    }

}
