package br.com.lucasbibianot.dao;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.lucasbibianot.entidades.EntidadeBase;

public class DAOBase<T extends EntidadeBase> {

	@Inject
	private EntityManager entityManager;

	protected Session getSession() {
		return (Session) this.entityManager.getDelegate();
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	public T salvar(T entidade) {
		return (T) getSession().save(entidade);
	}

	public void remover(final Object object) {
		entityManager.remove(object);
	}

	/***/
	public T recuperarPorId(final Class<T> type, final Long id) {
		return (T) getSession().get(type, id);
	}

	/***/
	public T merge(final T o) {
		return (T) getSession().merge(o);
	}

	/***/
	public void salvarOuAtualizar(final T o) {
		getSession().saveOrUpdate(o);
	}

	public List<T> recuperarTodos(Class<T> classe) {
		final Criteria crit = getSession().createCriteria(classe);
		return crit.list();
	}

	public List<T> executarQuery(String sql, Map<String, Object> parametros) {

		Query query = this.getEntityManager().createQuery(sql.toString());
		if (parametros != null) {
			for (String key : parametros.keySet()) {
				query.setParameter(key, parametros.get(key));
			}
		}
		return query.getResultList();

	}

	public T executarQuerySingle(String sql, Map<String, Object> parametros) {

		Query query = this.getEntityManager().createQuery(sql.toString());
		if (parametros != null) {
			for (String key : parametros.keySet()) {
				query.setParameter(key, parametros.get(key));
			}
		}
		return (T) query.getSingleResult();

	}

	public void flush() {
		this.entityManager.flush();
	}
}
