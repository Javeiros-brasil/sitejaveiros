package com.javeiros.server.dto;


import com.javeiros.server.enums.AreaDeAtuacao;
import com.javeiros.server.enums.PerfilCandidato;
import com.javeiros.server.models.Cadastro;
import org.springframework.beans.BeanUtils;

public class CadastroDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String numeroWhatsapp;
    private String perfilDiscord;
    private String email;
    private String perfilGithub;
    private PerfilCandidato perfilCandidato;
    private AreaDeAtuacao areaDeAtuacao;

    public CadastroDTO() {
    }

    public CadastroDTO(Cadastro entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNumeroWhatsapp() {
        return numeroWhatsapp;
    }

    public void setNumeroWhatsapp(String numeroWhatsapp) {
        this.numeroWhatsapp = numeroWhatsapp;
    }

    public String getPerfilDiscord() {
        return perfilDiscord;
    }

    public void setPerfilDiscord(String perfilDiscord) {
        this.perfilDiscord = perfilDiscord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfilGithub() {
        return perfilGithub;
    }

    public void setPerfilGithub(String perfilGithub) {
        this.perfilGithub = perfilGithub;
    }

    public PerfilCandidato getPerfilCandidato() {
        return perfilCandidato;
    }

    public void setPerfilCandidato(PerfilCandidato perfilCandidato) {
        this.perfilCandidato = perfilCandidato;
    }

    public AreaDeAtuacao getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(AreaDeAtuacao areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }

}
