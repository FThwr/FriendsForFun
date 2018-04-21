package de.hwrberlin.FriendsForFun.persistence.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import de.hwrberlin.FriendsForFun.persistence.PersistenceManager;

public abstract class AbstractEntityManager {

	public EntityManagerFactory emf;
	public PersistenceManager pm = PersistenceManager.getPersistenceManager();
	
	public void createObject(Object o) {
		save(o, false);
	}
	
	public void saveObject(Object o) {
		save(o, true);
	}
	
	private void save(Object obj, boolean exists) {

		emf = (new PersistenceManager()).getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			if (exists)
				em.merge(obj);
			else {
				em.persist(obj);
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	

	
}
