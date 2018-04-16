package de.hwrberlin.friendsforfun.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.hwrberlin.friendsforfun.persistence.PersistenceManager;

@Entity
public class Ort implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Ort")
	private int id;

	@Column(name = "Bez_Ort")
	String bez_ort;
	
	@Column(name = "PLZ")
	String plz;
	
	@Column(name = "Straﬂe")
	String strasse;
	
	@Column (name = "Beschreibung")
	String beschreibung;


	public Ort() {

	}

	public Ort (String bez_ort, String plz, String strasse, String beschreibung) {

		this.bez_ort = bez_ort;
		this.beschreibung = beschreibung;
		this.plz = plz;
		this.strasse = strasse;

		PersistenceManager pm = PersistenceManager.getPersistenceManager();
		pm.create(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBez_ort() {
		return bez_ort;
	}

	public void setBez_ort(String bez_ort) {
		this.bez_ort = bez_ort;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + "; Ort: " + bez_ort;
	}

}