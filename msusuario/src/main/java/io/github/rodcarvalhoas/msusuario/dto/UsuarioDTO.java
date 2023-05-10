package io.github.rodcarvalhoas.msusuario.dto;

import io.github.rodcarvalhoas.msusuario.model.Usuario;
import lombok.Data;

@Data
public class UsuarioDTO {

    private String cpf;
    private String nome;
    private String email;
    private String password;

    public Usuario toModel(){
        return new Usuario(cpf, nome, email, password);
    }

}
