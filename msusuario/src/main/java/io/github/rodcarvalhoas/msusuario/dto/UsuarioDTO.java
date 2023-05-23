package io.github.rodcarvalhoas.msusuario.dto;

import io.github.rodcarvalhoas.msusuario.model.Usuario;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UsuarioDTO {

    @NotBlank(message = "Campo CPF não pode ser vazio")
    @Size(message = "Deve ser inserido 11 digítos no campo CPF", min = 11 ,max = 11)
    private String cpf;

    @NotBlank(message = "Campo nome não pode ser vazio")
    @Size(max = 50)
    private String nome;

    @NotBlank(message = "Campo email não pode ser vazio")
    @Email
    private String email;

    @NotBlank(message = "Campo password não pode ser vazio")
    private String password;

    public Usuario toModel(){
        return new Usuario(cpf, nome, email, password);
    }

}
