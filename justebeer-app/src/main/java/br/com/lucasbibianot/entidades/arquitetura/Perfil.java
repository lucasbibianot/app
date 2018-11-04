package br.com.lucasbibianot.entidades.arquitetura;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.lucasbibianot.entidades.BaseEntidade;

@Entity
@Table(name = "TB_PERFIL")
@AttributeOverride(name = "id", column = @Column(name = "ID_PERFIL"))
public class Perfil extends BaseEntidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6204904668883098699L;
	@Column(name = "NM_PERFIL")
	private String nomePerfil;

	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

}
