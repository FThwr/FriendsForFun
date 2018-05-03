package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;

public class NutzerManager extends AbstractEntityManager {

	public NutzerManager() {

	}
	
 	/**
	 * @return Liste mit allen Nutzern
	 */
	public List<Nutzer> getNutzer() {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Nutzer> query = em.createQuery("SELECT e FROM Nutzer e", Nutzer.class);
			List<Nutzer> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}
	
	public void addNutzer(Nutzer nutzer) {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(nutzer);
		em.getTransaction().commit();
	}
	
	// TODO: spezielle Abfragen (z.B. alle Datentupel von dieser Klasse zurückgeben)

}
