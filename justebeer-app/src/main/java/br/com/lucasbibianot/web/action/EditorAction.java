package br.com.lucasbibianot.web.action;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("editor")
@RequestScoped
public class EditorAction {
	private String value = "This editor is provided by PrimeFaces";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
