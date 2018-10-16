package br.com.lucasbibianot.entidades.negocio;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.lucasbibianot.entidades.EntidadeBase;

@Entity
@Table(name = "TB_FABRICANTE")
@AttributeOverride(name = "id", column = @Column(name = "ID_RECIPIENTE"))
public class Fabricante extends EntidadeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2431044104971497163L;

	@Column(name = "NM_FABRICANTE")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
