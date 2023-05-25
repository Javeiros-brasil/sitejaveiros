package com.javeiros.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javeiros.server.model.Usuario;

/* UsuarioRepository é  uma interface que define a camada de acesso a dados (repositório) para a entidade Usuario */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
