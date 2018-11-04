package br.com.lucasbibianot.servicos;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.lucasbibianot.dao.TokenSegurancaDAO;
import br.com.lucasbibianot.entidades.seguranca.TokenSeguranca;
import br.com.lucasbibianot.exceptions.ErroOperacaoException;
import br.com.lucasbibianot.exceptions.MultiplusResultadosException;
import br.com.lucasbibianot.util.Constantes;

@RequestScoped
public class TokenSegurancaServico extends BaseServico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8928882762364502556L;

	@Inject
	private TokenSegurancaDAO tokenSegurancaDAO;
	@Inject
	private ParametroServico parametroServico;

	/**
	 * Retorna o secret configurado para a aplicação
	 * 
	 * @return
	 */
	public String getSecret() throws ErroOperacaoException {
		TokenSeguranca tokenSeguranca = null;
		try {
			tokenSeguranca = this.tokenSegurancaDAO
					.recuperar(this.parametroServico.getParametroString(Constantes.PARAM_NOM_TOKEN));
		} catch (MultiplusResultadosException e) {
			throw new ErroOperacaoException(e.getMessage(), e);
		}
		if (tokenSeguranca != null) {
			return tokenSeguranca.getSecret();
		} else {
			throw new ErroOperacaoException("Não foi possível localizar o token");
		}

	}

}
