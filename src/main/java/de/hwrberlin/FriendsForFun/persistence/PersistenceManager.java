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
}
