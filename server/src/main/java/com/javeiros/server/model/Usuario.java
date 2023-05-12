package com.javeiros.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.javeiros.server.enums.AreaDeAtuacao;
import com.javeiros.server.enums.PerfilCandidato;

@Entity
@Table(name = "cadastro")
public class Cadastro {
	// Descrição geral da classe
	// Esta classe representa um cadastro de usuário no sistema.

	// Atributos da classe
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String sobrenome;

	@Column(nullable = false)
	private String numeroWhatsapp;

	@Column(nullable = false)
	private String perfilDiscord;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String perfilGithub;

	@Enumerated(EnumType.STRING)
	private PerfilCandidato perfilCandidato;

	@Enumerated(EnumType.STRING)
	private AreaDeAtuacao areaDeAtuacao;

	// Construtor padrão, que não recebe parâmetros.
	public Cadastro() {
	}

	public Cadastro(Long id, String nome, String sobrenome, String numeroWhatsapp, String perfilDiscord, String email,
			String perfilGithub, PerfilCandidato perfilCandidato, AreaDeAtuacao areaDeAtuacao) {
		// Construtor que recebe todos os parâmetros necessários para criar um objeto
		// Cadastro.
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numeroWhatsapp = numeroWhatsapp;
		this.perfilDiscord = perfilDiscord;
		this.email = email;
		this.perfilGithub = perfilGithub;
		this.perfilCandidato = perfilCandidato;
		this.areaDeAtuacao = areaDeAtuacao;
	}

	// Getters e setters para cada atributo
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
