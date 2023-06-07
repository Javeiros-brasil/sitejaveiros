package com.javeiros.server.service;

import com.javeiros.server.dto.UsuarioDTO;
import com.javeiros.server.exception.UsuarioNaoSalvoException;
import com.javeiros.server.model.Usuario;
import com.javeiros.server.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository userRepository;

    public UsuarioDTO authenticate(String email, String senha) {

        Usuario user = userRepository.findByEmail(email);

        if (user != null && user.getSenha().equals(senha)){
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            BeanUtils.copyProperties(user, usuarioDTO);
            return usuarioDTO;
        }
        throw  new UsuarioNaoSalvoException("Erro ao logar email e/ou senha estão incorretos");
    }


}