package com.javeiros.server.repository;

import com.javeiros.server.model.AreaDeAtuacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaDeAtuacaoRepository extends JpaRepository<AreaDeAtuacao, Long> {

    AreaDeAtuacao findByNomeArea(String nome);

}
