package br.com.lucasbibianot.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;

public class DAOBase {

	@Inject
	private EntityManager entityManager;

	protected Session getSession() {
		return (Session) this.entityManager.getDelegate();
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	public <T> T salvar(T entidade) {
		return (T) getSession().save(entidade);
	}

	public void remover(final Object object) {
		entityManager.remove(object);
	}

	/***/
	public <T> T recuperarPorId(final Class<T> type, final Long id) {
		return (T) getSession().get(type, id);
	}

	/***/
	public <T> T merge(final T o) {
		return (T) getSession().merge(o);
	}

	/***/
	public <T> void salvarOuAtualizar(final T o) {
		getSession().saveOrUpdate(o);
	}

	public <T> List<T> recuperarTodos(final Class<T> type) {
		final Criteria crit = getSession().createCriteria(type);
		return crit.list();
	}

	public <T> List<T> executarQuery(Class<T> classe, String sql, Map<String, Object> parametros) {

		Query query = this.getEntityManager().createQuery(sql.toString());
		if (parametros != null) {
			for (String key : parametros.keySet()) {
				query.setParameter(key, parametros.get(key));
			}
		}
		return query.getResultList();

	}

	public void flush() {
		this.entityManager.flush();
	}
}
