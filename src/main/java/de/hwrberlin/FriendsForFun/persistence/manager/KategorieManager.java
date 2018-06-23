package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import de.hwrberlin.FriendsForFun.persistence.entities.Kategorie;

public class KategorieManager extends AbstractEntityManager {

	public KategorieManager() {

	}

	/**
	 * @return Liste mit allen Kategorien
	 */
	public List<Kategorie> getKategorien() {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Kategorie> query = em.createQuery("SELECT e FROM Kategorie e ORDER BY e.bez_kategorie", Kategorie.class);
			List<Kategorie> list = query.getResultList();
			return list;
		} finally {
			em.close();
		}
	}

	/**
	 * @return Liste mit allen Kategoriebezeichnungen
	 */
	public List<String> getKategoriebezeichnungen() {
		List<String> list = new ArrayList<String>();
		for (Kategorie k : getKategorien()) {
			list.add(k.getBez_kategorie());
		}
		return list;
	}

	/**
	 * @return Kategorie mit einer bestimmten ID
	 * 
	 */
	public Kategorie getKategorieByID(int ID) {
		emf = pm.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		try {
			Kategorie kategorie = em.createQuery("SELECT k FROM Kategorie k WHERE k.id = :katID", Kategorie.class)
					.setParameter("katID", ID).setMaxResults(1).getSingleResult();
			return kategorie;
		} finally {
			em.close();
		}
	}

}
