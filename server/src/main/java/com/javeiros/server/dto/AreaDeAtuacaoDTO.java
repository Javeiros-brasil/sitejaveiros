package com.javeiros.server.dto;

import com.javeiros.server.model.AreaDeAtuacao;
import com.javeiros.server.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class AreaDeAtuacaoDTO {


    private Long idArea;
    private String nomeArea;

    public AreaDeAtuacaoDTO(Long idArea, String nomeArea) {
        this.idArea = idArea;
        this.nomeArea = nomeArea;
    }

    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
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
                        areaDeAtuacao.getIdArea(),
                        areaDeAtuacao.getNomeArea()
                ))
                .collect(Collectors.toList());
    }

}
