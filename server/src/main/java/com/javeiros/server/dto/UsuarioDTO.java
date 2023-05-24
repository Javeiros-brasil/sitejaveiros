package com.javeiros.server.dto;

import org.springframework.beans.BeanUtils;
import com.javeiros.server.model.Usuario;
import com.javeiros.server.enums.AreaDeAtuacao;
import com.javeiros.server.enums.PerfilCandidato;

/*
	Classe UsuarioDTO
	=> sua função é transferir dados entre diferentes camadas da aplicação. Esta classe recebe
	os dados do formulário e transfere para o model Usuario que tem contato direto com o banco de dados.
*/

public class UsuarioDTO {

	private String nome;
	private String sobrenome;
	private String numeroWhatsapp;
	private String perfilDiscord;
	private String email;
	private String senha;
	private String perfilGithub;
	private PerfilCandidato perfilCandidato;
	private AreaDeAtuacao areaDeAtuacao;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario entity) {
		BeanUtils.copyProperties(entity, this);
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
