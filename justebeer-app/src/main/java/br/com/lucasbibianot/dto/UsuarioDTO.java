package br.com.lucasbibianot.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.lucasbibianot.entidades.arquitetura.Usuario;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6268995815939862562L;

	private String nomeUsuario;
	private String mail;
	private String senha;
	private String confirmacaoSenha;
	private PerfilDTO perfil;

	public UsuarioDTO(Usuario usuario) {
		this.nomeUsuario = usuario.getNomeUsuario();
		this.mail = usuario.getMail();
		this.perfil = new PerfilDTO(usuario.getPerfil());
	}

	public UsuarioDTO() {
		super();
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public PerfilDTO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

	public Usuario gerarEntidade() {
		Usuario usuario = new Usuario();
		usuario.setAtivo("S");
		usuario.setNomeUsuario(this.nomeUsuario);
		usuario.setMail(this.mail);
		usuario.setPerfil(this.perfil != null ? this.perfil.gerarEntidade() : null);
		return usuario;
	}
}
