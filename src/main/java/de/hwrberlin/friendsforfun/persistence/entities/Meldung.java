package de.hwrberlin.friendsforfun.persistence.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import de.hwrberlin.friendsforfun.persistence.PersistenceManager;

@Entity
public class Meldung implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Meldung")
	private int id;

	@Column(name = "Kommentar")
	String kommentar;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@Column (name = "Objekt_ID")
	Object object;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@Column (name = "Typ_ID")
	Typ typ;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@Column (name = "Melder")
	Nutzer nutzer;

	public Meldung() {

	}

	public Meldung (Object object, Typ typ, Nutzer nutzer, String kommentar) {

		this.kommentar = kommentar;
		this.object =object;
		this.typ =typ;
		this.nutzer =nutzer;

		PersistenceManager pm = PersistenceManager.getPersistenceManager();
		pm.create(this);
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
	
	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Typ getTyp() {
		return typ;
	}

	public void setTyp(Typ typ) {
		this.typ = typ;
	}

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
