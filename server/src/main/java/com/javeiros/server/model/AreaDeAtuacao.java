package com.javeiros.server.model;

import com.javeiros.server.dto.AreaDeAtuacaoDTO;
import com.javeiros.server.dto.UsuarioDTO;

import javax.persistence.*;

@Entity
public class AreaDeAtuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArea;
    @Column(nullable = false)
    private String nomeArea;

    public AreaDeAtuacao(){}

    public AreaDeAtuacao(Long idArea, String nomeArea) {
        this.idArea = idArea;
        this.nomeArea = nomeArea;
    }

    public Long getIdArea() {
        return idArea;
    }


    public String getNomeArea() {
        return nomeArea;
    }

    public void setNomeArea(String nomeArea) {
        this.nomeArea = nomeArea;
    }


    public void DtoParseModel(AreaDeAtuacaoDTO areaDeAtuacaoDTO){
        this.nomeArea = areaDeAtuacaoDTO.getNomeArea();

    }




}
