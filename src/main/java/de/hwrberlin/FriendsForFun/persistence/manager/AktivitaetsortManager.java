package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.hwrberlin.FriendsForFun.persistence.entities.Aktivitaetsort;

public class AktivitaetsortManager extends AbstractEntityManager {

	public AktivitaetsortManager() {

	}

	/**
	 * @return Liste mit allen Aktivitaetsorten
	 */
	public List<Aktivitaetsort> getAktivitaetsorte() {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Aktivitaetsort> query = em.createQuery("SELECT e FROM Aktivitaetsort e", Aktivitaetsort.class);
			List<Aktivitaetsort> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}

	}

}
