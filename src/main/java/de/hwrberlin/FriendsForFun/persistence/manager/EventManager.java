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

	public List<Event> getEventsByAktivitaet(int aktivitaetID) {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Event> query = em
					.createQuery("SELECT e FROM Event e WHERE e.aktivitaet.id = :aktivitaetID", Event.class)
					.setParameter("aktivitaetID", aktivitaetID);
			List<Event> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}
	
	public List<Event> getEventsByKategorie(int kategorieID) {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Event> query = em
					.createQuery("SELECT e FROM Event e WHERE e.aktivitaet.kategorie.id = :kategorieID", Event.class)
					.setParameter("kategorieID", kategorieID);
			List<Event> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}
	
	public List<Event> getEventsByAltersempfehlung(int alter) {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Event> query = em
					.createQuery("SELECT e FROM Event e WHERE e.aktivitaet.altersempfehlung = :altersempfehlung", Event.class)
					.setParameter("altersempfehlung", alter);
			List<Event> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}
	
	public List<Event> getEventsByOrt(int ortID) {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Event> query = em
					.createQuery("SELECT e FROM Event e WHERE e.ort.id = :ort", Event.class)
					.setParameter("ort", ortID);
			List<Event> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}
	
	public List<Event> getEventsByTermin(Date termin) {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Event> query = em
					.createQuery("SELECT e FROM Event e WHERE e.zeitpunkt = :termin", Event.class)
					.setParameter("termin", termin, TemporalType.DATE);
			List<Event> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}
	
}

// TODO: getEventsFromAktivitaet (Aktivitaet aktivitaet)
// TODO: getEventsFromOrganisator (Nutzer organisator)
