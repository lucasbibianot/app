package br.com.lucasbibianot.entidades.seguranca;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.lucasbibianot.entidades.BaseEntidade;

@Entity
@Table(name = "TB_TOKEN_SEGURANCA")
@AttributeOverride(name = "id", column = @Column(name = "ID_TOKEN_SEGURANCA"))
public class TokenSeguranca extends BaseEntidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7152878027658130808L;
	@Column(name = "NM_TOKEN")
	private String nomeToken;
	@Column(name = "DS_SECRET_KEY")
	private String secret;

	public String getNomeToken() {
		return nomeToken;
	}

	public void setNomeToken(String nomeToken) {
		this.nomeToken = nomeToken;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

}
