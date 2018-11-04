package br.com.lucasbibianot.dao;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import br.com.lucasbibianot.entidades.seguranca.TokenSeguranca;
import br.com.lucasbibianot.exceptions.MultiplusResultadosException;

@RequestScoped
public class TokenSegurancaDAO extends BaseDAO<TokenSeguranca> {

	/**
	 * Retorna o Token dado o seu nome
	 * 
	 * @param nome
	 * @return
	 * @throws MultiplusResultadosException
	 */
	public TokenSeguranca recuperar(String nome) throws MultiplusResultadosException {
		String sql = "select t from TokenSeguranca t where t.nomeToken = :nomeToken and t.ativo = 'S'";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nomeToken", nome);
		return this.executarQuerySingle(sql, parametros);
	}
}
