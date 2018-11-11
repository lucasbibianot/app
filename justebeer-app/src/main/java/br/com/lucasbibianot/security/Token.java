package br.com.lucasbibianot.security;

import java.io.Serializable;
import java.util.Date;

public class Token implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1872780260878534816L;
	private String mailUsuario;
	private String nomeUsuario;
	private Integer idPerfilUsuario;
	private Date dataValidade;
	private String issuer;
	private String subject;
	private String idToken;
	private Date dataCriacao;

	public Token(String mailUsuario, String nomeUsuario, Integer idPerfilUsuario, Date dataValidade, String issuer,
			String subject, String idToken, Date dataCriacao) {
		super();
		this.mailUsuario = mailUsuario;
		this.nomeUsuario = nomeUsuario;
		this.idPerfilUsuario = idPerfilUsuario;
		this.dataValidade = dataValidade;
		this.issuer = issuer;
		this.subject = subject;
		this.idToken = idToken;
		this.dataCriacao = dataCriacao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getMailUsuario() {
		return mailUsuario;
	}

	public void setMailUsuario(String mailUsuario) {
		this.mailUsuario = mailUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Integer getIdPerfilUsuario() {
		return idPerfilUsuario;
	}

	public void setIdPerfilUsuario(Integer idPerfilUsuario) {
		this.idPerfilUsuario = idPerfilUsuario;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getIdToken() {
		return idToken;
	}

	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}

}
