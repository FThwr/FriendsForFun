package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.hwrberlin.FriendsForFun.persistence.entities.Ort;

public class OrtManager extends AbstractEntityManager {

	public OrtManager() {

	}

	/**
	 * @return Liste mit allen Orten
	 */
	public List<Ort> getOrte() {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Ort> query = em.createQuery("SELECT e FROM Ort e", Ort.class);
			List<Ort> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}
}
