package br.com.lucasbibianot.entidades.arquitetura;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.lucasbibianot.entidades.EntidadeBase;

@Entity
@Table(name = "TB_PARAMETRO")
@AttributeOverride(name = "id", column = @Column(name = "ID_PARAMETRO"))
public class Parametro extends EntidadeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7129517006286983982L;
	@Column(name = "NM_PARAMETRO")
	private String nomeParametro;
	@Column(name = "VAL_PARAMETRO")
	private String valParametro;

	public String getNomeParametro() {
		return nomeParametro;
	}

	public void setNomeParametro(String nomeParametro) {
		this.nomeParametro = nomeParametro;
	}

	public String getValParametro() {
		return valParametro;
	}

	public void setValParametro(String valParametro) {
		this.valParametro = valParametro;
	}

}
