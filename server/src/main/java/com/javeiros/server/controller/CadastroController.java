package com.javeiros.server.controller;

import com.javeiros.server.dto.CadastroDTO;
import com.javeiros.server.model.Usuario;
import com.javeiros.server.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;


    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody CadastroDTO cadastroDTO) {
        cadastroService.cadastrarUsuario(cadastroDTO);
        String mensagem = "Usuário cadastrado com sucesso";
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }


}
