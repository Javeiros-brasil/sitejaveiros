package com.javeiros.server.controller;

import com.javeiros.server.dto.UsuarioDTO;
import com.javeiros.server.model.Usuario;

import com.javeiros.server.repository.UsuarioRepository;
import com.javeiros.server.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    /* Endpoint para cadastrar um novo usuário. O método recebe os dados do formulário que por sua vez é passado
    como argumento no método cadastrarUsuario da camada service. Cadastro sendo realizado com sucesso, é retornada
    a mensagem "Usuario cadastrado com sucesso". */
    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody UsuarioDTO cadastroDTO) {
        usuarioService.cadastrarUsuario(cadastroDTO);
        String mensagem = "Usuário cadastrado com sucesso";
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {

        //Procurar o usuário com o ID especificado no banco de dados
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);

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
        Usuario usuarioAtualizadoSalvo = usuarioRepository.save(usuarioExistente);

        //Retornar uma resposta 200 OK com o objeto do usuário atualizado
        return ResponseEntity.ok(usuarioAtualizadoSalvo);
    }
}
