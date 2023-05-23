package com.javeiros.server.service;

import com.javeiros.server.dto.UsuarioDTO;
import com.javeiros.server.model.Usuario;
import com.javeiros.server.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository cadastroRepository;
    public void cadastrarUsuario(UsuarioDTO cadastroDTO) {
       Usuario usuario = new Usuario();
       usuario.DtoParseModel(cadastroDTO);
       cadastroRepository.save(usuario);
    }

}

