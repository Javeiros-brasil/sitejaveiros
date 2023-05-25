package com.javeiros.server.controller;


import com.javeiros.server.dto.AreaDeAtuacaoDTO;
import com.javeiros.server.exception.EntidadeJaExisteException;
import com.javeiros.server.model.AreaDeAtuacao;
import com.javeiros.server.service.AreaDeAtuacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class AreaDeAtuacaoController {

    @Autowired
    private AreaDeAtuacaoService areaDeAtuacaoService;

    @PostMapping
    public ResponseEntity salvarNovaArea(@RequestBody AreaDeAtuacaoDTO areaDeAtuacaoDTO){

        try{
            AreaDeAtuacao skillSalva =areaDeAtuacaoService.salvar(areaDeAtuacaoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(skillSalva);

        }catch (EntidadeJaExisteException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }

    }


    @GetMapping
    public ResponseEntity listarAreas(){
        List<AreaDeAtuacao> areas = areaDeAtuacaoService.listar();
        return ResponseEntity.status(HttpStatus.OK).body(areas);

    }



}
