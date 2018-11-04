package br.com.lucasbibianot.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import br.com.lucasbibianot.entidades.negocio.Fornecedor;
import br.com.lucasbibianot.exceptions.MultiplusResultadosException;

@RequestScoped
public class FornecedorDAO extends BaseDAO<Fornecedor> {

	/**
	 * Retorna todos os fornecedores, dado um latitude e longitude
	 * 
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	public List<Fornecedor> recuperar(BigDecimal latitude, BigDecimal longitude) {
		String sql = "select f from Fornecedor f where f.latitude = :latitude and f.longitude = :longitude and f.ativo = 'S'";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("latitude", latitude);
		parametros.put("longitude", longitude);
		return this.executarQuery(sql, parametros);

	}

	/**
	 * Retorna o fornecedor pelo seu placeId
	 * 
	 * @param placeId
	 * @return
	 * @throws MultiplusResultadosException
	 */
	public Fornecedor recuperar(String placeId) throws MultiplusResultadosException {
		String sql = "select f from Fornecedor f where f.placeId = :placeId and f.ativo = 'S'";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("placeId", placeId);
		return this.executarQuerySingle(sql, parametros);
	}

}
