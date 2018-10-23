package br.com.lucasbibianot.entidades.negocio;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.lucasbibianot.entidades.EntidadeBase;

@Entity
@Table(name = "TB_PRODUTO")
@AttributeOverride(name = "id", column = @Column(name = "ID_PRODUTO"))
public class Produto extends EntidadeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2130168636389448573L;

	@Column(name = "NM_PRODUTO")
	private String nomeProduto;
	@ManyToOne
	@JoinColumn(name = "ID_FABRICANTE", referencedColumnName = "ID_FABRICANTE")
	private Fabricante fabricante;
	@ManyToOne
	@JoinColumn(name = "ID_RECIPIENTE", referencedColumnName = "ID_RECIPIENTE")
	private Recipiente recipiente;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Recipiente getRecipiente() {
		return recipiente;
	}

	public void setRecipiente(Recipiente recipiente) {
		this.recipiente = recipiente;
	}

}
