package br.com.lucasbibianot.web.action;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lucasbibianot.entidades.arquitetura.Usuario;
import br.com.lucasbibianot.exception.ErroConfirmacaoSenhaException;
import br.com.lucasbibianot.exception.ErroOperacaoException;
import br.com.lucasbibianot.exception.RegistroNaoEhUnicoException;
import br.com.lucasbibianot.service.UserService;

@Named("novoUsuarioAction")
@RequestScoped
public class NovoUsuarioAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5655608263678526074L;

	@Inject
	private UserService usuarioServico;

	private Usuario usuario = new Usuario();
	private String senha = new String();
	private String confirmacaoSenha = new String();

	/**
	 * Action para persistir o usuario
	 */
	public void criarUsuario() {
		try {
			this.usuarioServico.salvarUsuario(usuario, senha, confirmacaoSenha);
			this.addMensagemSucesso("Usuario cadastrado com sucesso");
			this.usuario = new Usuario();
		} catch (ErroOperacaoException | RegistroNaoEhUnicoException | ErroConfirmacaoSenhaException e) {
			this.addMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

	public String cancelar() {
		return "index.xhtml";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmacaoSenha() {
		return confirmacaoSenha;
	}

	public void setConfirmacaoSenha(String confirmacaoSenha) {
		this.confirmacaoSenha = confirmacaoSenha;
	}

}
