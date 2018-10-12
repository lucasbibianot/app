package br.com.lucasbibianot.web.action;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="editor")
public class EditorAction {
	private String value = "This editor is provided by PrimeFaces";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
