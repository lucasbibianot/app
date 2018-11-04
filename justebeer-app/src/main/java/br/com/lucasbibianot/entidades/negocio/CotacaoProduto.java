package br.com.lucasbibianot.entidades.negocio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.lucasbibianot.entidades.BaseEntidade;

@Entity
@Table(name = "TB_COTACAO_PRODUTO")
@AttributeOverride(name = "id", column = @Column(name = "ID_COTACAO_PRODUTO"))
public class CotacaoProduto extends BaseEntidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6868594708319334895L;

	@Column(name = "DT_COTACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCotacao;
	@ManyToOne
	@JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO")
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "ID_FORNECEDOR", referencedColumnName = "ID_FORNECEDOR")
	private Fornecedor fornecedor;
	@Column(name = "VAL_PRODUTO")
	private BigDecimal valorProduto;
	@Column(name = "DT_VALIDADE")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataValidade;
	@Column(name = "DS_OBSERVAO")
	private String observacao;

	public Calendar getDataCotacao() {
		return dataCotacao;
	}

	public void setDataCotacao(Calendar dataCotacao) {
		this.dataCotacao = dataCotacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public BigDecimal getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(BigDecimal valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
