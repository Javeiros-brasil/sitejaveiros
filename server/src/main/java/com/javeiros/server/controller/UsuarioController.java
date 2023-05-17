package com.javeiros.server.controller;

import com.javeiros.server.model.Usuario;
import com.javeiros.server.repositories.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private CadastroRepository cadastroRepository;

    @PostMapping //Cadastro de usuário
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return cadastroRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {

        //Procurar o usuário com o ID especificado no banco de dados
        Usuario usuarioExistente = cadastroRepository.findById(id).orElse(null);

        //Se o usuário não existir, retornar um erro 404 Not Found
        if (usuarioExistente == null) {
            return ResponseEntity.notFound().build();
        }

        //Atualizar os dados do usuário existente com as informações fornecidas na requisição
        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setSobrenome(usuarioAtualizado.getSobrenome());
        usuarioExistente.setNumeroWhatsapp(usuarioAtualizado.getNumeroWhatsapp());
        usuarioExistente.setPerfilDiscord(usuarioAtualizado.getPerfilDiscord());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setPerfilGithub(usuarioAtualizado.getPerfilGithub());
        usuarioExistente.setPerfilCandidato(usuarioAtualizado.getPerfilCandidato());
        usuarioExistente.setAreaDeAtuacao(usuarioAtualizado.getAreaDeAtuacao());

        //Salvar as mudanças no banco de dados
        Usuario usuarioAtualizadoSalvo = cadastroRepository.save(usuarioExistente);

        //Retornar uma resposta 200 OK com o objeto do usuário atualizado
        return ResponseEntity.ok(usuarioAtualizadoSalvo);
    }
}
