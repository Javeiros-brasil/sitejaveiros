package com.javeiros.server.service;

import com.javeiros.server.dto.CadastroDTO;
import com.javeiros.server.model.Usuario;
import com.javeiros.server.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository;
    public void cadastrarUsuario(CadastroDTO cadastroDTO) {
       Usuario usuario = new Usuario();
       usuario.DtoParseModel(cadastroDTO);
       cadastroRepository.save(usuario);
    }

}

