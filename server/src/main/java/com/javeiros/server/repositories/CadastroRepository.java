package com.javeiros.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javeiros.server.model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
}
