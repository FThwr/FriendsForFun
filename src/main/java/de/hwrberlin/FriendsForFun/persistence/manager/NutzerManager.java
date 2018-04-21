package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	
	// TODO: spezielle Abfragen (z.B. alle Datentupel von dieser Klasse zurückgeben)

}
