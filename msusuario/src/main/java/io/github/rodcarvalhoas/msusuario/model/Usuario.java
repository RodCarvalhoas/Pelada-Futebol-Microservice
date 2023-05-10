package io.github.rodcarvalhoas.msusuario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    private String cpf;
    private String nome;
    private String email;
    private String password;



}
