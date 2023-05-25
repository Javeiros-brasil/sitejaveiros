package com.javeiros.server.service;

import com.javeiros.server.dto.AreaDeAtuacaoDTO;
import com.javeiros.server.exception.EntidadeJaExisteException;
import com.javeiros.server.model.AreaDeAtuacao;
import com.javeiros.server.model.Usuario;
import com.javeiros.server.repository.AreaDeAtuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaDeAtuacaoService {

    @Autowired
    private AreaDeAtuacaoRepository areaDeAtuacaoRepository;


    public AreaDeAtuacao salvar(AreaDeAtuacaoDTO areaDeAtuacaoDTO){

        AreaDeAtuacao area = areaDeAtuacaoRepository.findByNomeArea(areaDeAtuacaoDTO.getNomeArea());

        if(area != null){
            throw new EntidadeJaExisteException(String.format("A Area de Atuação de nome %s ja esta cadastrada", areaDeAtuacaoDTO.getNomeArea()));
        }

        AreaDeAtuacao areaDeAtuacao = new AreaDeAtuacao();
        areaDeAtuacao.DtoParseModel(areaDeAtuacaoDTO);

        return areaDeAtuacaoRepository.save(areaDeAtuacao);
    }


    public List<AreaDeAtuacao> listar(){
        return areaDeAtuacaoRepository.findAll();
    }

}
