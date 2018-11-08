package br.com.lucasbibianot.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FornecedorEnvelopeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7237892545475199540L;
	private List<FornecedorDTO> fornecedores;

	public List<FornecedorDTO> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<FornecedorDTO> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
