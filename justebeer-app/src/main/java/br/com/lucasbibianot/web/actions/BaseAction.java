package br.com.lucasbibianot.web.actions;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BaseAction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void addMensagemSucesso(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, ""));
	}

	public void addMensagemErro(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, ""));
	}

	public void invalidarSessao() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

}
