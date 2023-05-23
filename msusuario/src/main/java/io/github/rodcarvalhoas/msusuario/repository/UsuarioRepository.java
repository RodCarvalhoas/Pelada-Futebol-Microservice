package io.github.rodcarvalhoas.msusuario.repository;

import io.github.rodcarvalhoas.msusuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findBycpf(String cpf);

    Optional<Usuario> findByemail(String cpf);

}
