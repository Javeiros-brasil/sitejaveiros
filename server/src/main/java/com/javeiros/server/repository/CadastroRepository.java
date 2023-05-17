package com.javeiros.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javeiros.server.model.Usuario;

@Repository
public interface CadastroRepository extends JpaRepository<Usuario, Long> {
}
