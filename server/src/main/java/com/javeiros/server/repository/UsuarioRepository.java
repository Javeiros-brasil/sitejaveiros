package com.javeiros.server.repository;

import com.javeiros.server.enums.AreaAtuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javeiros.server.model.Usuario;

import java.util.List;

/* UsuarioRepository é  uma interface que define a camada de acesso a dados (repositório) para a entidade Usuario */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);

    List<Usuario> findByNomeUsuarioContains(String nomeUsuario);
    List<Usuario> findByAreaAtuacao(AreaAtuacao nomeAreaDeAtuacao);

    List<Usuario> findByNomeUsuarioContainsAndAreaAtuacao(String nomeUsuario, AreaAtuacao nomeAreaDeAtuacao);


}
