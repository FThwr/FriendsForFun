package de.hwrberlin.FriendsForFun.persistence.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import de.hwrberlin.FriendsForFun.persistence.manager.MeldungManager;

@Entity
public class Meldung implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Meldung")
	private int id;

	@Column(name = "Kommentar")
	String kommentar;

	// @ManyToOne(cascade = CascadeType.MERGE)
	// @JoinColumn (name = "Objekt_ID")
	// Object object;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Nutzer_ID")
	Nutzer nutzerFS;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Event_ID")
	Event event;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Aktivitaet_ID")
	Aktivitaet aktivitaet;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Ort_ID")
	Ort ort;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Melder")
	Nutzer nutzer;

	public Meldung() {

	}

	public Meldung(String kommentar, Object object, Nutzer nutzer) {

		this.kommentar = kommentar;
		// this.object =object;
		this.nutzer = nutzer;

		MeldungManager mm = new MeldungManager();
		mm.createObject(this);
		// PersistenceManager pm = PersistenceManager.getPersistenceManager();
		// pm.create(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	// public Object getObject() {
	// return object;
	// }
	//
	// public void setObject(Object object) {
	// this.object = object;
	// }

	public Nutzer getNutzer() {
		return nutzer;
	}

	public void setNutzer(Nutzer nutzer) {
		this.nutzer = nutzer;
	}

	@Override
	public String toString() {
		return "ID: " + id + "Kommentar: " + kommentar;
	}

}
