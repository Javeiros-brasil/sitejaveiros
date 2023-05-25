package com.javeiros.server.service;

import com.javeiros.server.model.Usuario;
import com.javeiros.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository userRepository;

    public boolean authenticate(String email, String senha) {
        Usuario user = userRepository.findByEmail(email);
        if (user != null && user.getSenha().equals(senha)){
            return true;
        }
        return false;
    }
}