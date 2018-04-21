package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.hwrberlin.FriendsForFun.persistence.entities.Event;

public class EventManager extends AbstractEntityManager {

	public EventManager() {

	}

	/**
	 * @return Liste mit allen Events
	 */
	public List<Event> getEvents() {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Event> query = em.createQuery("SELECT e FROM Event e", Event.class);
			List<Event> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}

	// TODO: getEventsFromAktivitaet (Aktivitaet aktivitaet)
	// TODO: getEventsFromOrganisator (Nutzer organisator)

}
