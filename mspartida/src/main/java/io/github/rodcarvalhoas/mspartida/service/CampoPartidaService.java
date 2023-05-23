package io.github.rodcarvalhoas.mspartida.service;

import io.github.rodcarvalhoas.mspartida.exception.ResourceNotFoundException;
import io.github.rodcarvalhoas.mspartida.model.CampoPartida;
import io.github.rodcarvalhoas.mspartida.repository.CampoPartidaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CampoPartidaService {

    private final CampoPartidaRepository campoPartidaRepository;

    public Long salvarCampo(CampoPartida campoPartida) {
        Optional<CampoPartida> campo = campoPartidaRepository.findBynomeCampo(campoPartida.getNomeCampo());
        if(campo.isPresent()){
            throw new ResourceNotFoundException("Nome do campo já existe");
        }

        campoPartidaRepository.save(campoPartida);
        return campoPartida.getIdCampoPartida();
    }

    public List<CampoPartida> visualizarCampos(){
        return campoPartidaRepository.findAll();
    }

}
