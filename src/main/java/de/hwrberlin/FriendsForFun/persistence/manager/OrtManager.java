package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.entities.Ort;

public class OrtManager extends AbstractEntityManager {

	public OrtManager() {

	}

	/**
	 * 
	 * @param bez_ort
	 * @param plz
	 * @param strasse
	 * @return gibt einen bestimmten Ort anhand einer spezifischen Adresse zurück
	 * @throws NoResultException
	 */
	public Ort getOrte(String bez_ort, String plz, String strasse) throws NoResultException {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			return (Ort) em
					.createQuery("SELECT o FROM Ort o WHERE o.bez_ort = :oBez_ort AND o.plz = :oPlz AND o.strasse = :oStrasse")
					.setParameter("oBez_ort", bez_ort).setParameter("oPlz", plz).setParameter("oStrasse", strasse).setMaxResults(1)
					.getSingleResult();
			
		} finally {
			em.close();
		}
	}
	
	/**
	 * @return Liste mit allen Orten
	 */
	public List<Ort> getOrte() {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Ort> query = em.createQuery("SELECT e FROM Ort e ORDER BY e.bez_ort", Ort.class);
			List<Ort> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}
}
