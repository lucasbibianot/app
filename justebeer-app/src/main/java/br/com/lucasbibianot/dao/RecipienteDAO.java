package br.com.lucasbibianot.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import br.com.lucasbibianot.entidades.negocio.Recipiente;
import br.com.lucasbibianot.exceptions.MultiplusResultadosException;

@RequestScoped
public class RecipienteDAO extends BaseDAO<Recipiente> {

	/**
	 * Retorna o objeto recipiente dado o seu nome
	 * 
	 * @param nome
	 * @return
	 * @throws MultiplusResultadosException
	 */
	public Recipiente recuperar(String nome) throws MultiplusResultadosException {
		String sql = "select r from Recipiente r where r.ativo = 'S' and r.nome = :nome";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome", nome);
		return this.executarQuerySingle(sql, parametros);
	}
	
	/**
	 * Retorna o objeto recipiente dado o seu nome e volume
	 * 
	 * @param nome
	 * @return
	 * @throws MultiplusResultadosException
	 */
	public Recipiente recuperar(BigDecimal volume) throws MultiplusResultadosException {
		String sql = "select r from Recipiente r where r.ativo = 'S' and r.volume = :volume";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("volume", volume);
		return this.executarQuerySingle(sql, parametros);
	}	
}
