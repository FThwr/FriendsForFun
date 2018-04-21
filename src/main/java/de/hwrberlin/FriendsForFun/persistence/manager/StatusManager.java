package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.hwrberlin.FriendsForFun.persistence.entities.Status;

public class StatusManager extends AbstractEntityManager {

	public StatusManager() {

	}

	/**
	 * @return Liste mit allen Status
	 */
	public List<Status> getStatus() {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Status> query = em.createQuery("SELECT e FROM Status e", Status.class);
			List<Status> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}

}
