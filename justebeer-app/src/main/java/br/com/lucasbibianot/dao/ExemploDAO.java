package br.com.lucasbibianot.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.lucasbibianot.entidades.Exemplo;
import br.com.lucasbibianot.jpa.annotations.Repository;

@Repository
public class ExemploDAO {

	@Inject
	private EntityManager entityManager;

	public Exemplo getExemplo(Long codigo) {

		return this.entityManager.find(Exemplo.class, codigo);
	}

	public List<Exemplo> getTodos() {
		StringBuilder sql = new StringBuilder();
		sql.append("select o From Exemplo o");

		return this.entityManager.createQuery(sql.toString()).getResultList();
	}
}
