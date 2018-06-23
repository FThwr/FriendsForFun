package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.hwrberlin.FriendsForFun.persistence.entities.Meldung;

public class MeldungManager extends AbstractEntityManager {

	public MeldungManager() {

	}

	/**
	 * @return Liste mit allen Meldungen
	 */
	public List<Meldung> getMeldungen() {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Meldung> query = em.createQuery("SELECT e FROM Meldung e", Meldung.class);
			List<Meldung> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}

}
