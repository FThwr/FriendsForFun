package de.hwrberlin.FriendsForFun.persistence.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import de.hwrberlin.FriendsForFun.persistence.manager.AktivitaetsortManager;

@Entity
public class Aktivitaetsort implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Aktivitaetsort")
	private int id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Aktivitaet_ID")
	Aktivitaet aktivitaet;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Ort_ID")
	Ort ort;

	public Aktivitaetsort() {

	}

	public Aktivitaetsort(Aktivitaet aktivitaet, Ort ort) {

		this.aktivitaet = aktivitaet;
		this.ort = ort;

		AktivitaetsortManager aom = new AktivitaetsortManager();
		aom.createObject(this);
		// PersistenceManager pm=PersistenceManager.getPersistenceManager();
		// pm.create(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Aktivitaet getAktivitaet() {
		return aktivitaet;
	}

	public void setAktivitaet(Aktivitaet aktivitaet) {
		this.aktivitaet = aktivitaet;
	}

	public Ort getOrt() {
		return ort;
	}

	public void setOrt(Ort ort) {
		this.ort = ort;
	}

	@Override
	public String toString() {
		return "ID: " + id + "Aktivit�t: " + aktivitaet + "Ort: " + ort;
	}

}
