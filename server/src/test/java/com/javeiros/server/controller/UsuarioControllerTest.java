package com.javeiros.server.controller;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
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
    }

    @Test
    void deveSalvarUsuario_CadastrarUsuario() {
        /* Simulamos o método cadastrarUsuario() do serviço UsuarioService para que ele não faça nada (usando Mockito.doNothing()).
        Isso é feito para isolar o teste e focar na verificação do controlador em si. */
        Mockito.doNothing().when(usuarioService).cadastrarUsuario(Mockito.any(UsuarioDTO.class));

        //  Guardarmos a resposta do método cadastrarUsuario() do controlador usuarioController, passando o objeto usuarioDTO como parâmetro.
        ResponseEntity<String> response = usuarioController.cadastrarUsuario(usuarioDTO);

        // Verificando se status HTTP retornado do controlador é igual a CREATED. Se for diferente, o teste falhará.
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        // Verificamos se a mensagem de resposta contém a mensagem  esperada. Se não contiver, o teste falhará.
        assertEquals("Usuário cadastrado com sucesso", response.getBody());
    }

    @Test
    void deveRetornarBadRequest_CadastrarUsuario() {
        // Simulamos uma exceção lançada pelo UsuarioServiço
        Mockito.doThrow(RuntimeException.class).when(usuarioService).cadastrarUsuario(Mockito.any(UsuarioDTO.class));

        // Guardarmos a resposta do método cadastrarUsuario() do controlador usuarioController, passando o objeto usuarioDTO como parâmetro.
        ResponseEntity<String> response = usuarioController.cadastrarUsuario(usuarioDTO);

        // Verificamos se o estado HTTP retornado na resposta é igual a BAD_REQUEST. Se for diferente, o teste falhará.
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        // Verificamos se a mensagem de resposta contém a mensagem de erro esperada. Se não contiver, o teste falhará.
        assertEquals("Ocorreu um erro ao salvar o novo usuário, favor tente novamente", response.getBody());
    }

}
