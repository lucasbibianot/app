package br.com.lucasbibianot.web.actions;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lucasbibianot.entidades.arquitetura.Usuario;
import br.com.lucasbibianot.servicos.UsuarioServico;

@Named("novoUsuarioAction")
@RequestScoped
public class NovoUsuarioAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5655608263678526074L;

	@Inject
	private UsuarioServico usuarioServico;

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
		} catch (Exception e) {
			this.addMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

	public String cancelar() {
		return "index";
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
