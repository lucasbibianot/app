package br.com.lucasbibianot.jpa.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;

@ApplicationScoped
public class EntityManagerProducer {
	@Inject
	@PersistenceUnitName("justebeer-backend-pu")
	private EntityManagerFactory entityManagerFactory;

	@Produces
	@Default
	@RequestScoped
	public EntityManager create() {
		return this.entityManagerFactory.createEntityManager();
	}

	public void dispose(@Disposes @Default EntityManager entityManager) {
		if (entityManager.isOpen()) {
			entityManager.close();
		}
	}
}
