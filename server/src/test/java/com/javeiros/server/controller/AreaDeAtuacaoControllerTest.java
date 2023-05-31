package com.javeiros.server.controller;

import com.javeiros.server.dto.AreaDeAtuacaoDTO;
import com.javeiros.server.service.AreaDeAtuacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AreaDeAtuacaoControllerTest {

    @InjectMocks
    private AreaDeAtuacaoController areaDeAtuacaoController;

    @Mock
    private AreaDeAtuacaoService areaDeAtuacaoService;

    private AreaDeAtuacaoDTO areaDeAtuacaoDTO;

    @BeforeEach
    void setup(){
        areaDeAtuacaoDTO = new AreaDeAtuacaoDTO("Python");
    }

    @Test
    void deveSalvarUmaNovaAreaDeAtuacao(){
        areaDeAtuacaoController.salvarNovaArea(areaDeAtuacaoDTO);

    }


}
