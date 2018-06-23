package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;

public class NutzerManager extends AbstractEntityManager {

	public NutzerManager() {

	}

	/**
	 * @return Liste mit allen Nutzern
	 */
	public List<Nutzer> getNutzer() {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Nutzer> query = em.createQuery("SELECT e FROM Nutzer e", Nutzer.class);
			List<Nutzer> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return gibt einen bestimmten Nutzer anhand eines Nutzernamens und Passwortes
	 *         zurück
	 * @throws NoResultException
	 */
	public Nutzer getNutzer(String username, String password) throws NoResultException {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			return (Nutzer) em
					.createQuery("SELECT u FROM Nutzer u WHERE u.passwort = :uPassword AND u.username = :uUsername")
					.setParameter("uPassword", password).setParameter("uUsername", username).setMaxResults(1)
					.getSingleResult();

		} finally {
			em.close();
		}
	}

	/**
	 * 
	 * @param username
	 * @return Nutzer anhand seines Nutzernames
	 * @throws NoResultException
	 */
	public Nutzer getNutzer(String username) throws NoResultException {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			return (Nutzer) em.createQuery("SELECT u FROM Nutzer u WHERE u.username = :uUsername")
					.setParameter("uUsername", username).setMaxResults(1).getSingleResult();

		} finally {
			em.close();
		}
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return Nutzer mit dem neu gesetzten Nutzernamen und Passwort
	 * @throws NoResultException
	 */
	public Nutzer setNutzer(String username, String password) throws NoResultException {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			return (Nutzer) em.createQuery("UPDATE Nutzer u SET u.username = '1' WHERE u.username = :uUsername")
					.setParameter("uUsername", username).setMaxResults(1);
		} finally {
			em.close();
		}
	}

}
