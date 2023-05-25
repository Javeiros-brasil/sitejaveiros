package com.javeiros.server.dto;

import com.javeiros.server.model.AreaDeAtuacao;
import com.javeiros.server.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class AreaDeAtuacaoDTO {

    private String nomeArea;


    public AreaDeAtuacaoDTO() {
    }

    public AreaDeAtuacaoDTO(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    public String getNomeArea() {
        return nomeArea;
    }

    public void setNomeArea(String nomeArea) {
        this.nomeArea = nomeArea;
    }


    public static List<AreaDeAtuacaoDTO> converterListDto(List<AreaDeAtuacao> areas) {
        return areas.stream()
                .map(areaDeAtuacao -> new AreaDeAtuacaoDTO(
                        areaDeAtuacao.getNomeArea()
                ))
                .collect(Collectors.toList());
    }

}
