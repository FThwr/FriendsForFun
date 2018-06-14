package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import de.hwrberlin.FriendsForFun.persistence.entities.Event;
import de.hwrberlin.FriendsForFun.persistence.entities.Kategorie;
import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;

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

	public List<Event> getEventsBy(int alter, int kategorieId, int aktivitaetId, Date termin, int ortId) {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		String sql = "SELECT e FROM Event e WHERE ";
		Date terminPlus = new Date(termin.getTime());

		if (alter != 0) {
			sql += "e.aktivitaet.altersempfehlung = :altersempfehlung AND ";
		}
		if (kategorieId != 0) {
			sql += "e.aktivitaet.kategorie.id = :kategorieID AND ";
		}
		if (aktivitaetId != 0) {
			sql += "e.aktivitaet.id = :aktivitaetID AND ";
		}
		if (termin != null) {
			sql += "(e.zeitpunkt < :terminPlus AND e.zeitpunkt > :termin) AND ";
		}
		if(ortId != 0) {
			sql += "e.ort.id = :ort AND ";
		}
		sql = sql.substring(0, sql.length() - 5); // letztes AND soll entfernt werden
		try {
			TypedQuery<Event> query = em.createQuery(sql, Event.class);
			if (alter != 0) {
				query.setParameter("altersempfehlung", alter);
			}
			if (kategorieId != 0) {
				query.setParameter("kategorieID", kategorieId);
			}
			if (aktivitaetId != 0) {
				query.setParameter("aktivitaetID", aktivitaetId);
			}
			if (termin != null) {
				query.setParameter("termin", termin);
				terminPlus.setDate(terminPlus.getDate()+1);
				query.setParameter("terminPlus", terminPlus);
			}
			if(ortId != 0) {
				query.setParameter("ort", ortId);
			}
			List<Event> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}

}

// TODO: getEventsFromAktivitaet (Aktivitaet aktivitaet)
// TODO: getEventsFromOrganisator (Nutzer organisator)
