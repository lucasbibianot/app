package br.com.lucasbibianot.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ExemploEnvelopeDTO {

	private List<ExemploDTO> lista;

	public ExemploEnvelopeDTO() {
		super();
	}

	public ExemploEnvelopeDTO(List<ExemploDTO> lista) {
		super();
		this.lista = lista;
	}

	public List<ExemploDTO> getLista() {
		return lista;
	}

	public void setLista(List<ExemploDTO> lista) {
		this.lista = lista;
	}

}
