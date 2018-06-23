package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.hwrberlin.FriendsForFun.persistence.entities.Event;
import de.hwrberlin.FriendsForFun.persistence.entities.Eventteilnehmer;
import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;

public class EventteilnehmerManager extends AbstractEntityManager {

	public EventteilnehmerManager() {

	}

	/**
	 * @return Liste mit allen Eventteilnehmer-Objekten
	 */
	public List<Eventteilnehmer> getEventteilnehmer() {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Eventteilnehmer> query = em.createQuery("SELECT e FROM Eventteilnehmer e",
					Eventteilnehmer.class);
			List<Eventteilnehmer> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}

	/**
	 * @return Überprüft, ob ein Nutzer bereits an einem bestimmten Event teilnimmt
	 */
	public boolean isTeilnehmerAlreadyIn(Event event, Nutzer nutzer) {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Eventteilnehmer> query = em.createQuery(
					"SELECT e FROM Eventteilnehmer e WHERE e.event.id = :eventId AND e.nutzer.id = :nutzerID",
					Eventteilnehmer.class);
			return query.setParameter("eventId", event.getId()).setParameter("nutzerID", nutzer.getId())
					.getSingleResult() != null;
		} finally {
			em.close();
		}
	}

}
