package com.javeiros.server.model;

import com.javeiros.server.dto.AreaDeAtuacaoDTO;
import com.javeiros.server.dto.UsuarioDTO;

import javax.persistence.*;

@Entity
public class AreaDeAtuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArea;

    private String nomeArea;


    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
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
