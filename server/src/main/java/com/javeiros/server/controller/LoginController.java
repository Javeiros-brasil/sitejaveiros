package com.javeiros.server.controller;

import com.javeiros.server.dto.LoginRequest;
import com.javeiros.server.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private AuthService authService;

//    @PostMapping("/login")
//    public String login(@RequestBody LoginRequest loginRequest){
//        String email = loginRequest.getEmail();
//        String senha = loginRequest.getSenha();
//
//        if (authService.authenticate(email, senha)){
//            return "Login efetuado com sucesso!";
//        } else {
//            return "Credenciais inválidas!";
//        }
//    }
}