package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import de.hwrberlin.FriendsForFun.persistence.entities.Aktivitaet;

public class AktivitaetManager extends AbstractEntityManager {

	public AktivitaetManager() {

	}

	/**
	 * @return Liste mit allen Aktivitaeten
	 */
	public List<Aktivitaet> getAktivitaeten() {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Aktivitaet> query = em.createQuery("SELECT e FROM Aktivitaet e", Aktivitaet.class);
			List<Aktivitaet> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}

	/**
	 * 
	 * @param bez_aktivitaet
	 * @return Aktivität nach einer bestimmten Bezeichnung
	 * @throws NoResultException
	 */
	public Aktivitaet getAktivitaet(String bez_aktivitaet) throws NoResultException {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			return (Aktivitaet) em.createQuery(
					"SELECT a FROM Aktivitaet a WHERE a.bez_aktivitaet = :aBez_aktivitaet ORDER BY e.bez_aktivitaet")
					.setParameter("aBez_aktivitaet", bez_aktivitaet).setMaxResults(1).getSingleResult();

		} finally {
			em.close();
		}
	}

	/**
	 * @return Liste mit den Aktivitäten als JSON-String, ein bisschen geschummelt
	 */
	public String getAktivitaetenJSON() {
		return getAktivitaeten().toString();
	}

	/**
	 * @return Liste der Aktivitäten mit einer bestimmten Altersempfehlung
	 */
	public List<Aktivitaet> getAktivitaetenByAlter(int alter) {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Aktivitaet> query = em
					.createQuery("SELECT e FROM Aktivitaet e WHERE altersempfehlung = :alter", Aktivitaet.class)
					.setParameter("alter", alter);
			List<Aktivitaet> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}

}
