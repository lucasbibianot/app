package br.com.lucasbibianot.entidades.negocio;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.lucasbibianot.entidades.BaseEntidade;

@Entity
@Table(name = "TB_RECIPIENTE")
@AttributeOverride(name = "id", column = @Column(name = "ID_RECIPIENTE"))
public class Recipiente extends BaseEntidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2119695576117372062L;

	@Column(name = "NM_RECIPIENTE")
	private String nome;
	@Column(name = "VAL_VOLUME")
	private BigDecimal volume;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

}
