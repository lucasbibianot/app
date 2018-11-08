package br.com.lucasbibianot.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.lucasbibianot.entidades.negocio.Fornecedor;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FornecedorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3284344337766740893L;
	private String nomeFornecedor;
	private String referencia;
	private String identificador;
	private String endereco;
	private String placeId;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private String telefone;
	private String webSite;
	private Integer cep;
	private Integer numero;
	private String rua;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String contatoTel;
	private String contatoEMail;
	private String email;
	private String nomeExibicao;

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getContatoTel() {
		return contatoTel;
	}

	public void setContatoTel(String contatoTel) {
		this.contatoTel = contatoTel;
	}

	public String getContatoEMail() {
		return contatoEMail;
	}

	public void setContatoEMail(String contatoEMail) {
		this.contatoEMail = contatoEMail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeExibicao() {
		return this.nomeExibicao;
	}

	/**
	 * Instancia o DTO a partir da entidade Fornecedor
	 * 
	 * @param fornecedor
	 */
	public FornecedorDTO(Fornecedor fornecedor) {
		this.bairro = fornecedor.getBairro();
		this.cep = fornecedor.getCep();
		this.cidade = fornecedor.getCidade();
		this.complemento = fornecedor.getComplemento();
		this.contatoEMail = fornecedor.getContatoEMail();
		this.contatoTel = fornecedor.getContatoTel();
		this.email = fornecedor.getEmail();
		this.endereco = fornecedor.getEndereco();
		this.identificador = fornecedor.getIdentificador();
		this.latitude = fornecedor.getLatitude();
		this.longitude = fornecedor.getLongitude();
		this.nomeFornecedor = fornecedor.getNomeFornecedor();
		this.numero = fornecedor.getNumero();
		this.placeId = fornecedor.getPlaceId();
		this.referencia = fornecedor.getReferencia();
		this.rua = fornecedor.getRua();
		this.telefone = fornecedor.getTelefone();
		this.uf = fornecedor.getUf();
		this.webSite = fornecedor.getWebSite();
		this.nomeExibicao = this.nomeFornecedor + " - " + this.referencia;

	}

	public FornecedorDTO() {
		super();
	}

}
