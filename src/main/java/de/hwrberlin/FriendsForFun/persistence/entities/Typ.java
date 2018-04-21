package de.hwrberlin.FriendsForFun.persistence.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Typ implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Typ")
	private int id;

	@Column(name = "Bez_Typ")
	String bez_typ;
	
	@OneToMany(mappedBy = "typ")
	Set<Meldung> meldung;

	public Typ() {

	}

	public Typ (String bez_typ) {

		this.bez_typ = bez_typ;

//		PersistenceManager pm = PersistenceManager.getPersistenceManager();
//		pm.create(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBez_typ() {
		return bez_typ;
	}

	public void setBez_typ(String bez_typ) {
		this.bez_typ = bez_typ;
	}
	
	public Set<Meldung> getMeldung() {
		return meldung;
	}

	public void setMeldung(Set<Meldung> meldung) {
		this.meldung = meldung;
	}

	@Override
	public String toString() {
		return "ID: " + id + "Typ: " + bez_typ;
	}

}
