package com.javeiros.server.controller;

import com.javeiros.server.dto.UsuarioDTO;
import com.javeiros.server.enums.AreaAtuacao;
import com.javeiros.server.enums.PerfilCandidato;
import com.javeiros.server.exception.AreaAtuacaoNaoExisteException;
import com.javeiros.server.exception.EntidadeJaExisteException;
import com.javeiros.server.exception.PerfilCandidatoNaoExisteException;
import com.javeiros.server.exception.UsuarioNaoSalvoException;
import com.javeiros.server.model.Usuario;
import com.javeiros.server.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {
    @InjectMocks
    private UsuarioController usuarioController;
    @Mock
    private UsuarioService usuarioService;





    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    /*
    *   TESTAR CENÁRIOS: usuarioDTO sem atributos obrigatorios / sem atributos opcionais
    *
    *   TESTAR HIBERNATE VALIDATOR COM TELEFONE / EMAIL
    * */

    @Test
    void cadastrarUsuario_Sucesso() {
        // Dados de entrada
        UsuarioDTO usuarioDTO = new UsuarioDTO("Erasmo", "Bezerra", "(27) 99751-2017",
                "Erasmo Bezerra#9245", "erasmo.ads.tech@gmail.com", "sd34r3ferf34f",
                "erasmobezerra", PerfilCandidato.JUNIOR, AreaAtuacao.FRONTEND);

        Usuario novoUsuario = new Usuario(1L, "Erasmo", "Bezerra", "(27) 99751-2017",
                "Erasmo Bezerra#9245", "erasmo.ads.tech@gmail.com", "sd34r3ferf34f",
                "erasmobezerra", PerfilCandidato.JUNIOR, AreaAtuacao.FRONTEND);

        when(usuarioService.cadastrarUsuario(any(UsuarioDTO.class))).thenReturn(novoUsuario);

        ResponseEntity<?> responseEntity = usuarioController.cadastrarUsuario(usuarioDTO);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Usuário cadastrado com sucesso", responseEntity.getBody());
        verify(usuarioService, times(1)).cadastrarUsuario(any(UsuarioDTO.class));
    }

    @Test
    void cadastrarUsuario_Sucesso_SemValoresOpcionais(){
        UsuarioDTO usuarioDTO = new UsuarioDTO("Erasmo", "Bezerra", "(27) 99751-2017",
                "", "erasmo.ads.tech@gmail.com", "sd34r3ferf34f",
                "", PerfilCandidato.JUNIOR, AreaAtuacao.FRONTEND);

        Usuario novoUsuario = new Usuario(1L, "Erasmo", "Bezerra", "(27) 99751-2017",
                "", "erasmo.ads.tech@gmail.com", "sd34r3ferf34f",
                "", PerfilCandidato.JUNIOR, AreaAtuacao.FRONTEND);

        when(usuarioService.cadastrarUsuario(any(UsuarioDTO.class))).thenReturn(novoUsuario);

        ResponseEntity<?> responseEntity = usuarioController.cadastrarUsuario(usuarioDTO);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Usuário cadastrado com sucesso", responseEntity.getBody());
        verify(usuarioService, times(1)).cadastrarUsuario(any(UsuarioDTO.class));
    }

    @Test
    void cadastrarUsuario_CONFLICT_EmailJaExiste()  {
        // Dados de entrada
        UsuarioDTO usuarioDTO = new UsuarioDTO("Erasmo", "Bezerra", "(27) 99751-2017",
                "Erasmo Bezerra#9245", "erasmo.ads.tech@gmail.com", "sd34r3ferf34f",
                "erasmobezerra", PerfilCandidato.JUNIOR, AreaAtuacao.FRONTEND);

        // Mock do serviço para lançar exceção
        when(usuarioService.cadastrarUsuario(any(UsuarioDTO.class)))
                .thenThrow(new EntidadeJaExisteException("Este email já foi cadastrado por outro usuário."));

        // Chamar o método do controlador e capturar a resposta
        ResponseEntity<?> responseEntity = usuarioController.cadastrarUsuario(usuarioDTO);

        // Verificar se o serviço foi chamado uma vez
        verify(usuarioService, times(1)).cadastrarUsuario(any(UsuarioDTO.class));

        // Verificar o resultado da resposta
        assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
        assertEquals("Este email já foi cadastrado por outro usuário.", responseEntity.getBody());
    }

    @Test
    void cadastrarUsuario_BAD_REQUEST_SemValoresObrigatorios(){
        UsuarioDTO usuarioDTO = new UsuarioDTO("Erasmo", "", "",
                "Erasmo Bezerra#9245", "erasmo.ads.tech@gmail.com", "",
                "erasmobezerra", PerfilCandidato.JUNIOR, AreaAtuacao.FRONTEND);

        when(usuarioService.cadastrarUsuario(any(UsuarioDTO.class)))
                .thenThrow(new UsuarioNaoSalvoException("Erro ao salvar o usuário."));

        ResponseEntity<?> responseEntity = usuarioController.cadastrarUsuario(usuarioDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Erro ao salvar o usuário.", responseEntity.getBody());
        verify(usuarioService, times(1)).cadastrarUsuario(any(UsuarioDTO.class));
    }


    @Test
    void cadastrarUsuario_BAD_REQUEST_TelefoneInvalido(){
        UsuarioDTO usuarioDTO = new UsuarioDTO("Erasmo", "", "27997512017",
                "Erasmo Bezerra#9245", "erasmo.ads.tech@gmail.com", "",
                "erasmobezerra", PerfilCandidato.JUNIOR, AreaAtuacao.FRONTEND);

        when(usuarioService.cadastrarUsuario(any(UsuarioDTO.class)))
                .thenThrow(new UsuarioNaoSalvoException("Erro ao salvar o usuário."));

        ResponseEntity<?> responseEntity = usuarioController.cadastrarUsuario(usuarioDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Erro ao salvar o usuário.", responseEntity.getBody());
        verify(usuarioService, times(1)).cadastrarUsuario(any(UsuarioDTO.class));
    }

    @Test
    void cadastrarUsuario_BAD_REQUEST_EmailInvalido(){
        UsuarioDTO usuarioDTO = new UsuarioDTO("Erasmo", "Bezerra", "(27) 99751-2017",
                "", "erasmo.ads.tech@@gmail.com", "sd34r3ferf34f",
                "", PerfilCandidato.JUNIOR, AreaAtuacao.FRONTEND);

        when(usuarioService.cadastrarUsuario(any(UsuarioDTO.class)))
                .thenThrow(new UsuarioNaoSalvoException("Erro ao salvar o usuário."));

        ResponseEntity<?> responseEntity = usuarioController.cadastrarUsuario(usuarioDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Erro ao salvar o usuário.", responseEntity.getBody());
        verify(usuarioService, times(1)).cadastrarUsuario(any(UsuarioDTO.class));
    }


    @Test
    void deveRetornarUsuarioBuscadoNoFiltro() {
        UsuarioDTO usuarioDTO = new UsuarioDTO("Erasmo", "Bezerra", "(27) 99751-2017",
                "Erasmo Bezerra#9245", "erasmo.ads.tech@gmail.com", "sd34r3ferf34f",
                "erasmobezerra", PerfilCandidato.JUNIOR, AreaAtuacao.FRONTEND);

        Usuario novoUsuario = new Usuario(1L, "Erasmo", "Bezerra", "(27) 99751-2017",
                "Erasmo Bezerra#9245", "erasmo.ads.tech@gmail.com", "sd34r3ferf34f",
                "erasmobezerra", PerfilCandidato.JUNIOR, AreaAtuacao.FRONTEND);

        // Mock do resultado do serviço
        when(usuarioService.filtroUsuario("Erasmo",AreaAtuacao.FRONTEND))
                .thenReturn(Arrays.asList(usuarioDTO));

        ResponseEntity<List<UsuarioDTO>> response = usuarioController.filtroUsuario("Erasmo", AreaAtuacao.FRONTEND );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains(usuarioDTO));

        }
    }



