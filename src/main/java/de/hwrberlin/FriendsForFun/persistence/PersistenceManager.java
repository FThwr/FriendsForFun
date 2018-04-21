package de.hwrberlin.FriendsForFun.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

	private static PersistenceManager instance = null;
	private EntityManagerFactory emf = null;

	public static boolean IS_IN_TEST = false;

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
	public EntityManagerFactory getEntityManagerFactory() {

		if (emf == null) {
			if (!IS_IN_TEST)
				emf = Persistence.createEntityManagerFactory("default");
			else
				emf = Persistence.createEntityManagerFactory("test");
		}
		return emf;
	}

	/** Gibt einen EntityManager zur�ck (wird f�r Tests benutzt) **/
	public EntityManager getNewEntityManager() {

		EntityManagerFactory emf = getEntityManagerFactory();
		return emf.createEntityManager();
	}

//	/**
//	 * Internal method for saving, exists determines if Objects needs to be created
//	 * first
//	 * 
//	 * @param obj
//	 * @param exists
//	 */
//	private void save(Object obj, boolean exists) {
//
//		EntityManagerFactory emf = getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		try {
//			em.getTransaction().begin();
//			if (exists)
//				em.merge(obj);
//			else {
//				em.persist(obj);
//			}
//			em.getTransaction().commit();
//		} finally {
//			em.close();
//		}
//	}
//
//	/**
//	 * Erstellt einen Benutzer
//	 * 
//	 * @param benutzer
//	 */
//	public void create(Nutzer benutzer) {
//
//		save((Object) benutzer, false);
//	}
//
//	/**
//	 * Speichert einen Benutzer
//	 * 
//	 * @param benutzer
//	 */
//	public void save(Nutzer benutzer) {
//
//		save((Object) benutzer, true);
//	}
//
//	/**
//	 * Erstellt eine Aktivit�t
//	 * 
//	 * @param aktivitaet
//	 */
//	public void create(Aktivitaet aktivitaet) {
//
//		save((Object) aktivitaet, false);
//	}
//
//	/**
//	 * Speichert eine Aktivit�t
//	 * 
//	 * @param aktivitaet
//	 */
//	public void save(Aktivitaet aktivitaet) {
//
//		save((Object) aktivitaet, true);
//	}
//
//	/**
//	 * Erstellt ein Event
//	 * 
//	 * @param event
//	 */
//	public void create(Event event) {
//
//		save((Object) event, false);
//	}
//
//	/**
//	 * Speichert ein Event
//	 * 
//	 * @param event
//	 */
//	public void save(Event event) {
//
//		save((Object) event, true);
//	}
//
//	/**
//	 * Erstellt einen Ort
//	 * 
//	 * @param ort
//	 */
//	public void create(Ort ort) {
//
//		save((Object) ort, false);
//	}
//
//	/**
//	 * Speichert einen Ort
//	 * 
//	 * @param ort
//	 */
//	public void save(Ort ort) {
//
//		save((Object) ort, true);
//	}
//
//	/**
//	 * Erstellt eine Kategorie
//	 * 
//	 * @param kategorie
//	 */
//	public void create(Kategorie kategorie) {
//
//		save((Object) kategorie, false);
//	}
//
//	/**
//	 * Speichert eine Kategorie
//	 * 
//	 * @param kategorie
//	 */
//	public void save(Kategorie kategorie) {
//
//		save((Object) kategorie, true);
//	}
//
//	/**
//	 * Erstellt einen Status
//	 * 
//	 * @param status
//	 */
//	public void create(Status status) {
//
//		save((Object) status, false);
//	}
//
//	/**
//	 * Speichert eine Status
//	 * 
//	 * @param status
//	 */
//	public void save(Status status) {
//
//		save((Object) status, true);
//	}
//
//	/**
//	 * Erstellt eine Meldung
//	 * 
//	 * @param meldung
//	 */
//	public void create(Meldung meldung) {
//
//		save((Object) meldung, false);
//	}
//
//	/**
//	 * Speichert eine Meldung
//	 * 
//	 * @param meldung
//	 */
//	public void save(Meldung meldung) {
//
//		save((Object) meldung, true);
//	}
//
//	/**
//	 * Erstellt einen Meldungstyp
//	 * 
//	 * @param typ
//	 */
//	public void create(Typ typ) {
//
//		save((Object) typ, false);
//	}
//
//	/**
//	 * Speichert einen Meldungstyp
//	 * 
//	 * @param typ
//	 */
//	public void save(Typ typ) {
//
//		save((Object) typ, true);
//	}
//
//	/**
//	 * Erstellt einen Aktivit�tsort
//	 * 
//	 * @param aktivitaetsort
//	 */
//	public void create(Aktivitaetsort aktivitaetsort) {
//
//		save((Object) aktivitaetsort, false);
//	}
//
//	/**
//	 * Speichert einen Aktivit�tsort
//	 * 
//	 * @param aktivitaetsort
//	 */
//	public void save(Aktivitaetsort aktivitaetsort) {
//
//		save((Object) aktivitaetsort, true);
//	}
//
//	/**
//	 * Erstellt einen Eventteilnehmer
//	 * 
//	 * @param eventteilnehmer
//	 */
//	public void create(Eventteilnehmer eventteilnehmer) {
//
//		save((Object) eventteilnehmer, false);
//	}
//
//	/**
//	 * Speichert einen Eventteilnehmer
//	 * 
//	 * @param eventteilnehmer
//	 */
//	public void save(Eventteilnehmer eventteilnehmer) {
//
//		save((Object) eventteilnehmer, true);
//	}
//
//	//
//	// GET METHODS
//	//
//
//	/** Gibt alle Nutzer zurück (läd aus DB) **/
//	public List<Nutzer> getNutzer() {
//
//		EntityManagerFactory emf = getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		try {
//			TypedQuery<Nutzer> query = em.createQuery("SELECT e FROM Nutzer e", Nutzer.class);
//			List<Nutzer> list = query.getResultList();
//			return list;
//		} finally {
//			em.close();
//		}
//	}
//
//	/** Gibt alle Aktivitaten zurück (läd aus DB) **/
//	public List<Aktivitaet> getAktivitaeten() {
//
//		EntityManagerFactory emf = getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		try {
//			TypedQuery<Aktivitaet> query = em.createQuery("SELECT e FROM Aktivitaet e", Aktivitaet.class);
//			List<Aktivitaet> list = query.getResultList();
//			return list;
//		} finally {
//			em.close();
//		}
//	}
//
//	/** Gibt alle Aktivitaetsorte zurück (läd aus DB) **/
//	public List<Aktivitaetsort> getAktivitaetsorte() {
//
//		EntityManagerFactory emf = getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		try {
//			TypedQuery<Aktivitaetsort> query = em.createQuery("SELECT e FROM Aktivitaetsort e", Aktivitaetsort.class);
//			List<Aktivitaetsort> list = query.getResultList();
//			return list;
//		} finally {
//			em.close();
//		}
//	}
//
//	/** Gibt alle Events zurück (läd aus DB) **/
//	public List<Event> getEvents() {
//
//		EntityManagerFactory emf = getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		try {
//			TypedQuery<Event> query = em.createQuery("SELECT e FROM Event e", Event.class);
//			List<Event> list = query.getResultList();
//			return list;
//		} finally {
//			em.close();
//		}
//	}
//
//	/** Gibt alle Eventteilnehmer zurück (läd aus DB) **/
//	public List<Eventteilnehmer> getEventteilnehmer() {
//
//		EntityManagerFactory emf = getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		try {
//			TypedQuery<Eventteilnehmer> query = em.createQuery("SELECT e FROM Eventteilnehmer e",
//					Eventteilnehmer.class);
//			List<Eventteilnehmer> list = query.getResultList();
//			return list;
//		} finally {
//			em.close();
//		}
//	}
//
//	/** Gibt alle Kategorien zurück (läd aus DB) **/
//	public List<Kategorie> getKategorien() {
//
//		EntityManagerFactory emf = getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		try {
//			TypedQuery<Kategorie> query = em.createQuery("SELECT e FROM Kategorie e", Kategorie.class);
//			List<Kategorie> list = query.getResultList();
//			return list;
//		} finally {
//			em.close();
//		}
//	}
//
//	/** Gibt alle Meldungen zurück (läd aus DB) **/
//	public List<Meldung> getMeldungen() {
//
//		EntityManagerFactory emf = getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		try {
//			TypedQuery<Meldung> query = em.createQuery("SELECT e FROM Meldung e", Meldung.class);
//			List<Meldung> list = query.getResultList();
//			return list;
//		} finally {
//			em.close();
//		}
//	}
//
//	/** Gibt alle Orte zurück (läd aus DB) **/
//	public List<Ort> getOrte() {
//
//		EntityManagerFactory emf = getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		try {
//			TypedQuery<Ort> query = em.createQuery("SELECT e FROM Ort e", Ort.class);
//			List<Ort> list = query.getResultList();
//			return list;
//		} finally {
//			em.close();
//		}
//	}
//
//	/** Gibt alle Status zurück (läd aus DB) **/
//	public List<Status> getStatus() {
//
//		EntityManagerFactory emf = getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		try {
//			TypedQuery<Status> query = em.createQuery("SELECT e FROM Status e", Status.class);
//			List<Status> list = query.getResultList();
//			return list;
//		} finally {
//			em.close();
//		}
//	}
//
//	/** Gibt alle Typen zurück (läd aus DB) **/
//	public List<Typ> getTypen() {
//
//		EntityManagerFactory emf = getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		try {
//			TypedQuery<Typ> query = em.createQuery("SELECT e FROM Typ e", Typ.class);
//			List<Typ> list = query.getResultList();
//			return list;
//		} finally {
//			em.close();
//		}
//	}

}
