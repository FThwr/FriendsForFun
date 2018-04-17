package de.hwrberlin.FriendsForFun.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.hwrberlin.FriendsForFun.persistence.entities.*;

public class PersistenceManager {

	private static PersistenceManager instance = null;
	private EntityManagerFactory emf = null;

	// public static boolean IS_IN_TEST = false;

	public PersistenceManager() {
	}

	/**
	 * Gibt die PeristenceManager Instanz zur�ck, erstellt eine neue Instanz, falls
	 * keine Vorhanden
	 **/
	public static PersistenceManager getPersistenceManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (instance == null)
			instance = new PersistenceManager();
		return instance;
	}

	/**
	 * Gibt eine EntityManagerFactory Instanz zur�ck, erstellt eine neue Instanz,
	 * falls keine vorhanden
	 **/
	private EntityManagerFactory getEntityManagerFactory() {

		if (emf == null) {
			// if (!IS_IN_TEST)
			emf = Persistence.createEntityManagerFactory("default");
			// else
			// emf = Persistence.createEntityManagerFactory("test");
		}
		return emf;
	}

	// /** Gibt einen EntityManager zur�ck (wird f�r Tests benutzt) **/
	// public EntityManager getNewEntityManager() {
	//
	// EntityManagerFactory emf = getEntityManagerFactory();
	// return emf.createEntityManager();
	// }
	
	/**
	 * Internal method for saving, exists determines if Objects needs to be created
	 * first
	 * 
	 * @param obj
	 * @param exists
	 */
	private void save(Object obj, boolean exists) {

		EntityManagerFactory emf = getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			if (exists)
				em.merge(obj);
			else {
				em.persist(obj);
//				MyUI.logger.debug("DB-Objekt erstellt: " + obj.getClass().getName().split("\\.")[6] + " ("
//						+ obj.toString() + ")");
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	
	/**
	 * Erstellt einen Benutzer
	 * @param benutzer
	 */
	public void create(Nutzer benutzer) {

		save((Object) benutzer, false);
	}
	
	/**
	 * Speichert einen Benutzer
	 * @param benutzer
	 */
	public void save(Nutzer benutzer) {

		save((Object) benutzer, true);
	}
	
	/**
	 * Erstellt eine Aktivit�t
	 * @param aktivitaet
	 */
	public void create(Aktivitaet aktivitaet) {

		save((Object) aktivitaet, false);
	}
	
	/**
	 * Speichert eine Aktivit�t
	 * @param aktivitaet
	 */
	public void save(Aktivitaet aktivitaet) {

		save((Object) aktivitaet, true);
	}

	/**
	 * Erstellt ein Event
	 * @param event
	 */
	public void create(Event event) {

		save((Object) event, false);
	}
	
	/**
	 * Speichert ein Event
	 * @param event
	 */
	public void save(Event event) {

		save((Object) event, true);
	}

	/**
	 * Erstellt einen Ort
	 * @param ort
	 */
	public void create(Ort ort) {

		save((Object) ort, false);
	}
	
	/**
	 * Speichert einen Ort
	 * @param ort
	 */
	public void save(Ort ort) {

		save((Object) ort, true);
	}

	/**
	 * Erstellt eine Kategorie
	 * @param kategorie
	 */
	public void create(Kategorie kategorie) {

		save((Object) kategorie, false);
	}
	
	/**
	 * Speichert eine Kategorie
	 * @param kategorie
	 */
	public void save(Kategorie kategorie) {

		save((Object) kategorie, true);
	}

	/**
	 * Erstellt einen Status
	 * @param status
	 */
	public void create(Status status) {

		save((Object) status, false);
	}
	
	/**
	 * Speichert eine Status
	 * @param status
	 */
	public void save(Status status) {

		save((Object) status, true);
	}
	
	/**
	 * Erstellt eine Meldung
	 * @param meldung
	 */
	public void create(Meldung meldung) {

		save((Object) meldung, false);
	}
	
	/**
	 * Speichert eine Meldung
	 * @param meldung
	 */
	public void save(Meldung meldung) {

		save((Object) meldung, true);
	}

	/**
	 * Erstellt einen Meldungstyp
	 * @param typ
	 */
	public void create(Typ typ) {

		save((Object) typ, false);
	}
	
	/**
	 * Speichert einen Meldungstyp
	 * @param typ
	 */
	public void save(Typ typ) {

		save((Object) typ, true);
	}

	/**
	 * Erstellt einen Aktivit�tsort
	 * @param aktivitaetsort
	 */
	public void create(Aktivitaetsort aktivitaetsort) {

		save((Object) aktivitaetsort, false);
	}
	
	/**
	 * Speichert einen Aktivit�tsort
	 * @param aktivitaetsort
	 */
	public void save(Aktivitaetsort aktivitaetsort) {

		save((Object) aktivitaetsort, true);
	}
	
	/**
	 * Erstellt einen Eventteilnehmer
	 * @param eventteilnehmer
	 */
	public void create(Eventteilnehmer eventteilnehmer) {

		save((Object) eventteilnehmer, false);
	}
	
	/**
	 * Speichert einen Eventteilnehmer
	 * @param eventteilnehmer
	 */
	public void save(Eventteilnehmer eventteilnehmer) {

		save((Object) eventteilnehmer, true);
	}
	

}
