package br.com.lucasbibianot.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.deltaspike.core.util.StringUtils;

import br.com.lucasbibianot.dao.PerfilDAO;
import br.com.lucasbibianot.dao.UsuarioDAO;
import br.com.lucasbibianot.entidades.arquitetura.Perfil;
import br.com.lucasbibianot.entidades.arquitetura.Usuario;
import br.com.lucasbibianot.exception.ErroConfirmacaoSenhaException;
import br.com.lucasbibianot.exception.ErroOperacaoException;
import br.com.lucasbibianot.exception.MultiplusResultadosException;
import br.com.lucasbibianot.exception.RegistroNaoEhUnicoException;
import br.com.lucasbibianot.exception.UserNotAuthenticatedException;
import br.com.lucasbibianot.util.Criptografia;

@RequestScoped
public class UserService extends ServicoBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6669466304645839271L;
	@Inject
	private UsuarioDAO daoUsuario;
	@Inject
	private PerfilDAO daoPerfil;
	@Inject
	private ParametroServico parametroServico;

	/**
	 * Serviço que realiza a autenticação do usuário
	 * 
	 * @param email
	 * @param senha
	 * @return
	 * @throws UserNotAuthenticatedException
	 */
	public Boolean autenticar(String email, String senha) throws UserNotAuthenticatedException {
		if (StringUtils.isEmpty(email) && StringUtils.isEmpty(senha)) {
			throw new UserNotAuthenticatedException("O email e a senha são obrigatorios");
		}
		try {
			Usuario usuario = this.recuperar(email);
			if (usuario == null) {
				throw new UserNotAuthenticatedException("Usuário não encontrado");
			}
			String senhaCriptografada = Criptografia.criptografar(senha);
			if (senhaCriptografada.equals(usuario.getSenha())) {
				return Boolean.TRUE;
			} else {
				throw new UserNotAuthenticatedException("Senha Inválida");
			}
		} catch (UnsupportedEncodingException e) {
			throw new UserNotAuthenticatedException("Erro na autenticacao", e);
		} catch (NoSuchAlgorithmException e) {
			throw new UserNotAuthenticatedException("Erro na autenticacao", e);
		}
	}

	/**
	 * Persiste o usuário
	 * 
	 * @param usuario
	 * @throws RegistroNaoEhUnicoException
	 */
	public void salvarUsuario(Usuario usuario, String senha, String confirmacaoSenha)
			throws ErroConfirmacaoSenhaException, ErroOperacaoException, RegistroNaoEhUnicoException {
		try {

			if (this.recuperar(usuario.getMail()) != null) {
				throw new RegistroNaoEhUnicoException("O email utilizado já existe.");
			}

			if (senha != null && confirmacaoSenha != null && senha.equals(confirmacaoSenha)) {
				usuario.setSenha(Criptografia.criptografar(senha));
			} else {
				throw new ErroConfirmacaoSenhaException("Erro ao confirmar a senha");
			}

			Perfil perfilPadrao = this.daoPerfil.recuperarPorId(Perfil.class, parametroServico.getParametroLong("idPerfilPadrao"));
			usuario.setPerfil(perfilPadrao);
			usuario.setSalt("");
			usuario.setToken("");
			usuario.setAtivo("S");

			this.daoUsuario.salvarOuAtualizar(usuario);
		} catch (NoSuchAlgorithmException e) {
			throw new ErroOperacaoException("Erro na Operação", e);
		} catch (UnsupportedEncodingException e) {
			throw new ErroOperacaoException("Erro na Operação", e);
		}

	}

	/**
	 * Verifica se já existe um usuário no cadastro com o mesmo email
	 * 
	 * @param usuario
	 */
	public Usuario recuperar(String email) {
		try {
			return this.daoUsuario.recuperar(email);
		} catch (MultiplusResultadosException e) {
			e.printStackTrace();
		}
		return null;
	}

}
