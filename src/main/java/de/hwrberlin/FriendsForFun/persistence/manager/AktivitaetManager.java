package de.hwrberlin.FriendsForFun.persistence.manager;

import java.util.List;

import javax.persistence.EntityManager;
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

	// TODO: getAktivitaetFromKategorie (Kategorie kategorie)

}
