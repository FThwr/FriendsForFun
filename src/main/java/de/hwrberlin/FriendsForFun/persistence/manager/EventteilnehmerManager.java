package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.hwrberlin.FriendsForFun.persistence.entities.Eventteilnehmer;

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

	// TODO: getTeilnehmerFromEvent(Event event)
	// TODO: getEventsFromNutzer(Nutzer nutzer)

}
