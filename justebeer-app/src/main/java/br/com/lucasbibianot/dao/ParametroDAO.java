package br.com.lucasbibianot.dao;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import br.com.lucasbibianot.entidades.arquitetura.Parametro;
import br.com.lucasbibianot.exception.MultiplusResultadosException;

@RequestScoped
public class ParametroDAO extends DAOBase<Parametro> {

	/**
	 * Recupera o parâmetro dado o seu nome
	 * @param nome
	 * @return
	 * @throws MultiplusResultadosException
	 */
	public Parametro getParametro(String nome) throws MultiplusResultadosException {
		String sql = "select p from Parametro p where p.nomeParametro = :nomeParametro";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nomeParametro", nome);
		return this.executarQuerySingle(sql, parametros);
	}
}
