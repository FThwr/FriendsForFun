package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.hwrberlin.FriendsForFun.persistence.entities.Event;
import de.hwrberlin.FriendsForFun.persistence.entities.Eventteilnehmer;
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

	/**
	 * @return Liste mit den Events, die einen bestimmten Nutzer als Teilnehmer
	 *         haben
	 */
	public List<Event> getEventsByNutzer(Nutzer nutzer) {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Event> query = em.createQuery(
					"SELECT e FROM Event e, Eventteilnehmer t WHERE t.event.id = e.id AND t.nutzer.id = :nutzer",
					Event.class);
			List<Event> list = query.setParameter("nutzer", nutzer.getId()).getResultList();
			return list;
		} finally {
			em.close();
		}
	}

	/**
	 * 
	 * @param event
	 * @return gibt die Anzahl der Teilnehmer eines bestimmten Events zurück
	 */
	public int getAnzahlTeilnehmer(Event event) {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Eventteilnehmer> query = em
					.createQuery("SELECT e FROM Eventteilnehmer e WHERE e.event.id = :eventId", Eventteilnehmer.class);
			return query.setParameter("eventId", event.getId()).getResultList().size();
		} finally {
			em.close();
		}
	}

	/**
	 * @return Event mit bestimmter ID
	 */
	public Event getEventById(int id) {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Event> query = em.createQuery("SELECT e FROM Event e WHERE e.id = :id", Event.class);
			Event ergebnis = query.setParameter("id", id).getSingleResult();
			return ergebnis;
		} finally {
			em.close();
		}
	}

	/**
	 * 
	 * @param alter
	 * @param kategorieId
	 * @param aktivitaetId
	 * @param termin
	 * @param ortId
	 * @return Liste mit Events, gesucht nach bestimmten Kriterien
	 */
	public List<Event> getEventsBy(int alter, int kategorieId, int aktivitaetId, Date termin, int ortId) {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		String sql = "SELECT e FROM Event e WHERE ";
		if (termin != null) {
			sql += "(e.zeitpunkt < :terminPlus AND e.zeitpunkt > :termin) AND ";
		}
		if (alter != 0) {
			sql += "e.aktivitaet.altersempfehlung = :altersempfehlung AND ";
		}
		if (kategorieId != 0) {
			sql += "e.aktivitaet.kategorie.id = :kategorieID AND ";
		}
		if (aktivitaetId != 0) {
			sql += "e.aktivitaet.id = :aktivitaetID AND ";
		}
		if (ortId != 0) {
			sql += "e.ort.id = :ort AND ";
		}
		sql = sql.substring(0, sql.length() - 5); // letztes AND soll entfernt werden

		if (termin == null && alter == 0 && kategorieId == 0 && aktivitaetId == 0 && ortId == 0) {
			sql = "SELECT e FROM Event e";
		}
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
				Date terminPlus = new Date(termin.getTime());
				query.setParameter("termin", termin);
				terminPlus.setDate(terminPlus.getDate() + 1);
				query.setParameter("terminPlus", terminPlus);
			}
			if (ortId != 0) {
				query.setParameter("ort", ortId);
			}
			List<Event> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}

}
