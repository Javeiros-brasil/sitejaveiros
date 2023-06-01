package com.javeiros.server.service;

import com.javeiros.server.dto.UsuarioDTO;
import com.javeiros.server.exception.EntidadeJaExisteException;
import com.javeiros.server.exception.UsuarioNaoSalvoException;
import com.javeiros.server.model.Usuario;
import com.javeiros.server.repository.UsuarioRepository;
import com.javeiros.server.repository.filtro.UsuarioCustomRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioCustomRepository usuarioCustomRepository;

    public Usuario cadastrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario verificaEmail = usuarioRepository.findByEmail(usuarioDTO.getEmail());

        if (verificaEmail != null) {
            throw new EntidadeJaExisteException(String.format("Este email já foi cadastrado por outro usuário."));
        }

        try {
            Usuario novoUsuario = new Usuario();
            BeanUtils.copyProperties(usuarioDTO, novoUsuario);
            return usuarioRepository.save(novoUsuario);
        } catch (RuntimeException e) {
            throw new UsuarioNaoSalvoException(String.format("Erro ao salvar o usuário."));
        }
    }


    public List<UsuarioDTO> filtroUsuario(List<String> nomesArea, String nomeUsuario){

        List<Usuario> artigos = usuarioCustomRepository.filtroUsuario(nomesArea, nomeUsuario);


        return UsuarioDTO.converterListDto(artigos);

    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {

        //Procurar o usuário com o ID especificado no banco de dados
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);

        //Se o usuário não existir, vai retornar nulo
        if(usuarioExistente == null) {
            return null;
        }

        //Atualizar os dados do usuário existente com as informações fornecidas na requisição
        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setSobrenome(usuarioAtualizado.getSobrenome());
        usuarioExistente.setNumeroWhatsapp(usuarioAtualizado.getNumeroWhatsapp());
        usuarioExistente.setPerfilDiscord(usuarioAtualizado.getPerfilDiscord());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setPerfilGithub(usuarioAtualizado.getPerfilGithub());
        usuarioExistente.setPerfilCandidato(usuarioAtualizado.getPerfilCandidato());
        usuarioExistente.setAreas(usuarioAtualizado.getAreas());

        //Salvar as mudanças no banco de dados
        Usuario usuarioAtualizadoSalvo = usuarioRepository.save(usuarioExistente);

        //Retornar o usuário que foi atualizado
        return  usuarioAtualizadoSalvo;
    }




}

