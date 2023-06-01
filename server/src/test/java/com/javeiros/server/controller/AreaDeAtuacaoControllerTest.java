package com.javeiros.server.controller;

import com.javeiros.server.dto.AreaDeAtuacaoDTO;
import com.javeiros.server.exception.EntidadeJaExisteException;
import com.javeiros.server.model.AreaDeAtuacao;
import com.javeiros.server.repository.AreaDeAtuacaoRepository;
import com.javeiros.server.service.AreaDeAtuacaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class AreaDeAtuacaoControllerTest {

    @InjectMocks
    private AreaDeAtuacaoController areaDeAtuacaoController;

    @Mock
    private AreaDeAtuacaoService areaDeAtuacaoService;
    @Mock
    private AreaDeAtuacaoRepository areaDeAtuacaoRepository;

    private AreaDeAtuacaoDTO areaDeAtuacaoDTO;

    @BeforeEach
    void setup(){
        areaDeAtuacaoDTO = new AreaDeAtuacaoDTO("Python");

    }

    @Test
    void deveSalvarUmaNovaAreaDeAtuacao(){
        var response = Assertions.assertDoesNotThrow(()-> areaDeAtuacaoController.salvarNovaArea(areaDeAtuacaoDTO));
        Assertions.assertEquals(ResponseEntity.status(HttpStatus.CREATED).build(), response);

    }

    @Test
    void deveRetornarTodasAreaDeAtuacaoSalvas(){
        ResponseEntity response = areaDeAtuacaoController.listarAreas();
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

    }





}
