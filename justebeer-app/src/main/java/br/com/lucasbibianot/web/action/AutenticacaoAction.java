package br.com.lucasbibianot.web.action;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lucasbibianot.entidades.arquitetura.Usuario;
import br.com.lucasbibianot.exception.UserNotAuthenticatedException;
import br.com.lucasbibianot.service.UserService;

@Named("autenticacaoAction")
@SessionScoped
public class AutenticacaoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2654500917198694311L;
	private Usuario usuarioLogado;
	@Inject
	private UserService userService;

	private String email;
	private String senha;

	public String logar() {
		try {
			if (this.userService.autenticar(email, senha)) {
				this.usuarioLogado = this.userService.recuperar(email);
				if (usuarioLogado != null) {
					return "principal";
				}
			}
			this.addMensagemErro("Não foi possível realizar o logon");

		} catch (UserNotAuthenticatedException e) {
			this.addMensagemErro(e.getMessage());
			e.printStackTrace();
		}
		return "index.xhtml";
	}
	
	
	public Boolean usuarioLogado() {
		return this.usuarioLogado != null ? Boolean.TRUE : Boolean.FALSE;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}