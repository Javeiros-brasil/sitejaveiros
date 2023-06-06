package com.javeiros.server.model;

import javax.persistence.*;

import com.javeiros.server.dto.UsuarioDTO;
import com.javeiros.server.enums.AreaAtuacao;
import com.javeiros.server.enums.PerfilCandidato;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@Column(nullable = false)
	private String nomeUsuario;

	@Column(nullable = false)
	private String sobrenome;

	@Column(nullable = false)
	private String numeroWhatsapp;

	private String perfilDiscord;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = true)
	private String senha;

	private String perfilGithub;

	@Enumerated(EnumType.STRING)
	private PerfilCandidato perfilCandidato;

	@Enumerated(EnumType.STRING)
	private AreaAtuacao areaAtuacao;



	public Usuario() {
	}

	public Usuario(Long idUsuario, String nomeUsuario, String sobrenome, String numeroWhatsapp, String perfilDiscord,
				   String email, String senha, String perfilGithub, PerfilCandidato perfilCandidato, AreaAtuacao areaAtuacao) {
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.sobrenome = sobrenome;
		this.numeroWhatsapp = numeroWhatsapp;
		this.perfilDiscord = perfilDiscord;
		this.email = email;
		this.senha = senha;
		this.perfilGithub = perfilGithub;
		this.perfilCandidato = perfilCandidato;
		this.areaAtuacao = areaAtuacao;

	}


	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNome() {
		return nomeUsuario;
	}

	public void setNome(String nome) {
		this.nomeUsuario = nome;
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

	public String getSenha(){return senha;}

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


	public AreaAtuacao getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(AreaAtuacao areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
}
