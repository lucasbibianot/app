package br.com.lucasbibianot.entidades.arquitetura;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.lucasbibianot.entidades.BaseEntidade;

@Entity
@Table(name = "TB_USUARIO")
@AttributeOverride(name = "id", column = @Column(name = "ID_USUARIO"))
public class Usuario extends BaseEntidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1961344749002142940L;

	@Column(name = "NM_USUARIO")
	private String nomeUsuario;
	@Column(name = "DS_SENHA")
	private String senha;
	@Column(name = "MAIL_USUARIO")
	private String mail;
	@Column(name = "DS_TOKEN")
	private String token;
	@Column(name = "DS_SALT")
	private String salt;
	@ManyToOne
	@JoinColumn(name = "ID_PERFIL", referencedColumnName = "ID_PERFIL")
	private Perfil perfil;

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
