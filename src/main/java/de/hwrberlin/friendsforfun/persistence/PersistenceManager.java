package de.hwrberlin.friendsforfun.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.hwrberlin.friendsforfun.persistence.entities.*;

public class PersistenceManager {

	private static PersistenceManager instance = null;
	private EntityManagerFactory emf = null;

	// public static boolean IS_IN_TEST = false;

	public PersistenceManager() {
	}

	/**
	 * Gibt die PeristenceManager Instanz zurück, erstellt eine neue Instanz, falls
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
	 * Gibt eine EntityManagerFactory Instanz zurück, erstellt eine neue Instanz,
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

	// /** Gibt einen EntityManager zurück (wird für Tests benutzt) **/
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

}
