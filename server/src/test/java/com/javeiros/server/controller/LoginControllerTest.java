package com.javeiros.server.controller;

import com.javeiros.server.dto.UsuarioDTO;
import com.javeiros.server.enums.AreaAtuacao;
import com.javeiros.server.enums.PerfilCandidato;
import com.javeiros.server.service.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {


    @InjectMocks
    private LoginController loginController;

    @Mock
    private AuthService authService;

    UsuarioDTO usuarioDTO;

    @BeforeEach
    void setup(){
        usuarioDTO = new UsuarioDTO("Erasmo", "Bezerra", "27997512017",
                "Erasmo Bezerra#9245", "erasmo.ads.tech@gmail.com", "sd34r3ferf34f",
                "erasmobezerra", PerfilCandidato.JUNIOR, AreaAtuacao.FRONTEND);
    }


}
