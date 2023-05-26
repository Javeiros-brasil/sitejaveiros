package com.javeiros.server.controller;

import com.javeiros.server.controller.UsuarioController;
import com.javeiros.server.dto.AreaDeAtuacaoDTO;
import com.javeiros.server.dto.UsuarioDTO;
import com.javeiros.server.enums.PerfilCandidato;
import com.javeiros.server.model.AreaDeAtuacao;
import com.javeiros.server.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {
    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    UsuarioDTO usuarioDTO;


    @BeforeEach
    void setup(){
        usuarioDTO = new UsuarioDTO("Erasmo", "Bezerra", "27997512017",
                "Erasmo Bezerra#9245", "erasmo.ads.tech@gmail.com",
                "erasmobezerra", PerfilCandidato.JUNIOR, Arrays.asList( new AreaDeAtuacao(1L,"BACKEND"),
                                                                                  new AreaDeAtuacao(2L, "FRONTEND")));
    }

    @Test
    void deveCadastrarUsuario() {
        // Simular o método cadastrarUsuario do service
        Mockito.doNothing().when(usuarioService).cadastrarUsuario(Mockito.any(UsuarioDTO.class));
        ResponseEntity<String> response = usuarioController.cadastrarUsuario(usuarioDTO);

        // Verificaro status HTTP e a mensagem de resposta
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Usuário cadastrado com sucesso", response.getBody());
    }

}
