package br.com.lucasbibianot.dao;

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
}
