package com.javeiros.server.service;

import com.javeiros.server.dto.UsuarioDTO;
import com.javeiros.server.model.Usuario;
import com.javeiros.server.repository.UsuarioRepository;
import com.javeiros.server.repository.filtro.UsuarioCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository cadastroRepository;

    @Autowired
    private UsuarioCustomRepository usuarioCustomRepository;

    /* O método cadastrarUsuario recebe um objeto UsuarioDTO como parâmetro para então convertê-lo em um objeto
       model usuário O método save do cadastroRepository é chamado para salvar o objeto usuario
       no banco de dados. */
    public void cadastrarUsuario(UsuarioDTO cadastroDTO) {
       Usuario usuario = new Usuario();
       usuario.DtoParseModel(cadastroDTO);
       cadastroRepository.save(usuario);
    }


    public List<UsuarioDTO> filtroUsuario(List<String> nomesArea, String nomeUsuario){

        List<Usuario> artigos = usuarioCustomRepository.filtroUsuario(nomesArea, nomeUsuario);


        return UsuarioDTO.converterListDto(artigos);

    }




}

