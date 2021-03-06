package br.com.lucasbibianot.dao;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import br.com.lucasbibianot.entidades.arquitetura.Usuario;
import br.com.lucasbibianot.exceptions.MultiplusResultadosException;

@RequestScoped
public class UsuarioDAO extends BaseDAO<Usuario> {

	/**
	 * Retorna o usuário dado um email
	 * 
	 * @param email
	 * @return
	 * @throws MultiplusResultadosException
	 */
	public Usuario recuperar(String email) throws MultiplusResultadosException {
		String sql = "Select u from Usuario u where u.mail = :email and u.ativo = 'S'";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("email", email);
		return this.executarQuerySingle(sql, parametros);

	}

}
