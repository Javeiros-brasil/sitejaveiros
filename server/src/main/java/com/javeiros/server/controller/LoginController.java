package com.javeiros.server.controller;

import com.javeiros.server.dto.LoginRequest;
import com.javeiros.server.dto.UsuarioDTO;
import com.javeiros.server.exception.UsuarioNaoSalvoException;
import com.javeiros.server.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest){

        String email = loginRequest.getEmail();
        String senha = loginRequest.getSenha();

        try{
           UsuarioDTO usuarioDTO = authService.authenticate(email, senha);

           return ResponseEntity.status(HttpStatus.OK).body(usuarioDTO);

        }catch (UsuarioNaoSalvoException e){
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }
}