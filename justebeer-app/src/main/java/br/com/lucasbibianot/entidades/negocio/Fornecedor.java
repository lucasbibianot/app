package br.com.lucasbibianot.entidades.negocio;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.lucasbibianot.entidades.BaseEntidade;

@Entity
@Table(name = "TB_FORNECEDOR")
@AttributeOverride(name = "id", column = @Column(name = "ID_FORNECEDOR"))
public class Fornecedor extends BaseEntidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3659750009661532870L;

	@Column(name = "NM_FORNECEDOR")
	private String nomeFornecedor;
	@Column(name = "DS_REFERENCIA")
	private String referencia;
	@Column(name = "NM_IDENTIFICADOR")
	private String identificador;
	@Column(name = "DS_ENDERECO")
	private String endereco;
	@Column(name = "PLACE_ID")
	private String placeId;
	@Column(name = "NUM_LATITUDE")
	private BigDecimal latitude;
	@Column(name = "NUM_LONGITUDE")
	private BigDecimal longitude;
	@Column(name = "DS_TELEFONE")
	private String telefone;
	@Column(name = "DS_WEBSIT")
	private String webSite;
	@Column(name = "NUM_CEP")
	private Integer cep;
	@Column(name = "NUM_LOGRADOURO")
	private Integer numero;
	@Column(name = "NM_RUA")
	private String rua;
	@Column(name = "DS_COMPLEMENTO")
	private String complemento;
	@Column(name = "NM_BAIRRO")
	private String bairro;
	@Column(name = "NM_CIDADE")
	private String cidade;
	@Column(name = "DS_UF")
	private String uf;
	@Column(name = "NM_CONTATO_TEL")
	private String contatoTel;
	@Column(name = "NM_CONTATO_MAIL")
	private String contatoEMail;
	@Column(name = "DS_MAIL")
	private String email;

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

}
