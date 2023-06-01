package com.javeiros.server.controller;

import com.javeiros.server.dto.UsuarioDTO;
import com.javeiros.server.enums.PerfilCandidato;
import com.javeiros.server.exception.EntidadeJaExisteException;
import com.javeiros.server.exception.UsuarioNaoSalvoException;
import com.javeiros.server.model.AreaDeAtuacao;
import com.javeiros.server.service.UsuarioService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;



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
                                    "Erasmo Bezerra#9245", "erasmo.ads.tech@gmail.com", "sd34r3ferf34f",
                                    "erasmobezerra", PerfilCandidato.JUNIOR,
                                    Arrays.asList( new AreaDeAtuacao(1L,"BACKEND"),
                                                   new AreaDeAtuacao(2L, "FRONTEND")));

        novoUsuario = new Usuario(1L, "Erasmo", "Bezerra", "27997512017",
                                "Erasmo Bezerra#9245", "erasmo.ads.tech@gmail.com", "sd34r3ferf34f",
                                "erasmobezerra", PerfilCandidato.JUNIOR,
                                Arrays.asList( new AreaDeAtuacao(1L,"BACKEND"),
                                        new AreaDeAtuacao(2L, "FRONTEND")));
    }

    @Test
    void cadastrarUsuario_Sucesso() {
        when(usuarioService.cadastrarUsuario(usuarioDTO)).thenReturn(novoUsuario);

        ResponseEntity<?> response = usuarioController.cadastrarUsuario(usuarioDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(novoUsuario, response.getBody());
        verify(usuarioService, times(1)).cadastrarUsuario(usuarioDTO);
    }

    @Test
    void cadastrarUsuario_Conflito() {
        String mensagemErro = "Este email já foi cadastrado por outro usuário.";
        EntidadeJaExisteException excecao = new EntidadeJaExisteException(mensagemErro);
        when(usuarioService.cadastrarUsuario(usuarioDTO)).thenThrow(excecao);

        ResponseEntity<?> response = usuarioController.cadastrarUsuario(usuarioDTO);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals(mensagemErro, response.getBody());
        verify(usuarioService, times(1)).cadastrarUsuario(usuarioDTO);
    }

    @Test
    void cadastrarUsuario_Erro() {
        String mensagemErro = "Erro ao salvar o usuário.";
        UsuarioNaoSalvoException excecao = new UsuarioNaoSalvoException(mensagemErro);
        when(usuarioService.cadastrarUsuario(usuarioDTO)).thenThrow(excecao);

        ResponseEntity<?> response = usuarioController.cadastrarUsuario(usuarioDTO);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(mensagemErro, response.getBody());
        verify(usuarioService, times(1)).cadastrarUsuario(usuarioDTO);
    }

    @Test
    void deveRetornarUsuarioBuscadoNoFiltro() {


        ResponseEntity<List<Usuario>> response = usuarioController.filtroUsuario(Arrays.asList("BACKEND", "FRONTEND"), "Erasmo");

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertTrue(response.getBody().contains(usuarioDTO));
    }


}
