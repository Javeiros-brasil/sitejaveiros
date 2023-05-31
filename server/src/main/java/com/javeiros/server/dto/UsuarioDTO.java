package com.javeiros.server.dto;

import com.javeiros.server.model.AreaDeAtuacao;
import org.springframework.beans.BeanUtils;
import com.javeiros.server.model.Usuario;
import com.javeiros.server.enums.PerfilCandidato;

import java.util.List;
import java.util.stream.Collectors;

/*
	Classe UsuarioDTO
	=> sua função é transferir dados entre diferentes camadas da aplicação. Esta classe recebe
	os dados do formulário e transfere para o model Usuario que tem contato direto com o banco de dados.
*/

public class UsuarioDTO {

	private String nomeUsuario;
	private String sobrenome;
	private String numeroWhatsapp;
	private String perfilDiscord;
	private String email;
	private String senha;

	private String perfilGithub;
	private PerfilCandidato perfilCandidato;
	private List<AreaDeAtuacao> areas;

	public UsuarioDTO(String nomeUsuario, String sobrenome, String numeroWhatsapp, String perfilDiscord,
					  String email, String perfilGithub,PerfilCandidato perfilCandidato, List<AreaDeAtuacao> areas) {
		this.nomeUsuario = nomeUsuario;
		this.sobrenome = sobrenome;
		this.numeroWhatsapp = numeroWhatsapp;
		this.perfilDiscord = perfilDiscord;
		this.email = email;
		this.perfilGithub = perfilGithub;
		this.perfilCandidato = perfilCandidato;
		this.areas = areas;
	}
	// metodo que converte uma list<Usuario> para um List<usuarioDto>
	public static List<UsuarioDTO> converterListDto(List<Usuario> usuarios) {
		return usuarios.stream()
				.map(usuario -> new UsuarioDTO(
						usuario.getNomeUsuario(), usuario.getSobrenome(),
						usuario.getNumeroWhatsapp(), usuario.getPerfilDiscord(),
						usuario.getEmail(), usuario.getPerfilGithub(),
						usuario.getPerfilCandidato(), usuario.getAreas()
						))
				.collect(Collectors.toList());
	}



	public UsuarioDTO() {
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioDTO(Usuario entity) {
		BeanUtils.copyProperties(entity, this);
	}

	public List<AreaDeAtuacao> getAreas() {
		return areas;
	}

	public void setAreas(List<AreaDeAtuacao> areas) {
		this.areas = areas;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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



}
