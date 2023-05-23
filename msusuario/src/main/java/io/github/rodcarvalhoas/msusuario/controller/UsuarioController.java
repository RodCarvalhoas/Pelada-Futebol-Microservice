package io.github.rodcarvalhoas.msusuario.controller;

import io.github.rodcarvalhoas.msusuario.dto.UsuarioDTO;
import io.github.rodcarvalhoas.msusuario.model.Usuario;
import io.github.rodcarvalhoas.msusuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController implements Serializable {

    private final UsuarioService usuarioService;
    

    @GetMapping(params = "cpf")
    @ResponseStatus(HttpStatus.OK)
    public Usuario getUsuarioByCpf(@RequestParam("cpf") String cpf){
        Optional<Usuario> user = usuarioService.getUsuarioByCPF(cpf);
        return user.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
            Usuario usuario = usuarioDTO.toModel();
            usuarioService.saveUsuario(usuario);
            return usuario;
    }

    @DeleteMapping(params = "cpf")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirUsuario(@RequestParam("cpf") String cpf){
        usuarioService.deleteUsuario(cpf);
    }


}
