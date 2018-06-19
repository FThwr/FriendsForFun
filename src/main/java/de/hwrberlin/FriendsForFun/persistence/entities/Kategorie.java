package de.hwrberlin.FriendsForFun.persistence.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import de.hwrberlin.FriendsForFun.persistence.manager.KategorieManager;

@Entity
public class Kategorie implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Kategorie")
	private int id;

	@Column(name = "Bez_Kategorie")
	String bez_kategorie;

	@OneToMany(mappedBy = "kategorie")
	Set<Aktivitaet> aktivitaet;

	public Kategorie() {

	}

	public Kategorie(String bez_kategorie) {

		this.bez_kategorie = bez_kategorie;

		KategorieManager km = new KategorieManager();
		km.createObject(this);
		// PersistenceManager pm = PersistenceManager.getPersistenceManager();
		// pm.create(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBez_kategorie() {
		return bez_kategorie;
	}

	public void setBez_kategorie(String bez_kategorie) {
		this.bez_kategorie = bez_kategorie;
	}

	public Set<Aktivitaet> getAktivitaet() {
		return aktivitaet;
	}

	public void setAktivitaet(Set<Aktivitaet> aktivitaet) {
		this.aktivitaet = aktivitaet;
	}

	@Override
	public String toString() {
		return bez_kategorie;
	}

}