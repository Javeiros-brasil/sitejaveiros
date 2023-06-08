package com.javeiros.server.controller;

import com.javeiros.server.dto.UsuarioDTO;
import com.javeiros.server.enums.AreaAtuacao;
import com.javeiros.server.exception.EntidadeJaExisteException;
import com.javeiros.server.exception.UsuarioNaoSalvoException;
import com.javeiros.server.model.Usuario;
import com.javeiros.server.repository.UsuarioRepository;
import com.javeiros.server.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            usuarioService.cadastrarUsuario(usuarioDTO);
            return new ResponseEntity<>("Usuário cadastrado com sucesso", HttpStatus.CREATED);
        } catch (EntidadeJaExisteException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (UsuarioNaoSalvoException p) {
            return new ResponseEntity<>(p.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {

        Usuario usuario = usuarioService.atualizarUsuario(id, usuarioAtualizado);

        //Se o usuário não existir, retornar um erro 404 Not Found
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        //Retornar uma resposta 200 OK com o objeto do usuário atualizado
        return ResponseEntity.ok(usuario);
    }


    @GetMapping("/filtro")
    public ResponseEntity filtroUsuario(
            //@RequestParam faz com que os parâmetros do método se tornem parâmetros que podem ser passados na requisição.
            //Quando utilizado com "required = false", indica que o parâmetro não é obrigatório.
            @RequestParam(required = false) String nomeUsuario,
            @RequestParam(required = false) AreaAtuacao nomesArea
            ){

        List<UsuarioDTO> usuarios = usuarioService.filtroUsuario(nomeUsuario, nomesArea);

        return ResponseEntity.status(HttpStatus.OK).body(usuarios);

    }


}
