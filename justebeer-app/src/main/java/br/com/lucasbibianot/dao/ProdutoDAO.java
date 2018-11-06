package br.com.lucasbibianot.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import br.com.lucasbibianot.entidades.negocio.Produto;
import br.com.lucasbibianot.exceptions.MultiplusResultadosException;

@RequestScoped
public class ProdutoDAO extends BaseDAO<Produto> {

	/**
	 * Retorna um produto existente
	 * @param nome
	 * @param volume
	 * @return
	 * @throws MultiplusResultadosException
	 */
	public Produto recuperar(String nome, BigDecimal volume) throws MultiplusResultadosException {
		String sql = "select p from Produto p join p.recipiente r on p.nomeProduto = :nome and r.volume = :volume and p.ativo = 'S'";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nome", nome);
		parametros.put("volume", volume);
		return this.executarQuerySingle(sql, parametros);
	}

}
