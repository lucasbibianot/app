package br.com.lucasbibianot.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.lucasbibianot.entidades.arquitetura.Perfil;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PerfilDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5391427096339234407L;
	private Long id;
	private String nome;

	public PerfilDTO(Perfil perfil) {
		this.id = perfil.getId();
		this.nome = perfil.getNomePerfil();
	}

	public PerfilDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Perfil gerarEntidade() {
		Perfil perfil = new Perfil();
		perfil.setId(this.id);
		perfil.setNomePerfil(this.nome);
		return perfil;
	}

}
