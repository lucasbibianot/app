package br.com.lucasbibianot.dao;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import br.com.lucasbibianot.entidades.arquitetura.Usuario;
import br.com.lucasbibianot.exception.MultiplusResultadosException;

@RequestScoped
public class UsuarioDAO extends DAOBase<Usuario> {

	/**
	 * Retorna o usuário dado um email
	 * @param email
	 * @return
	 * @throws MultiplusResultadosException
	 */
	public Usuario recuperar(String email) throws MultiplusResultadosException {
		String sql = "Select u from Usuario u where u.mail = :email";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("email", email);
		try {
			return this.executarQuerySingle(sql, parametros);
		} catch (NonUniqueResultException e) {
			throw new MultiplusResultadosException("Existem usuário diferentes com o mesmo email", e);
		} catch (NoResultException e) {
			return null;
		}

	}

}
