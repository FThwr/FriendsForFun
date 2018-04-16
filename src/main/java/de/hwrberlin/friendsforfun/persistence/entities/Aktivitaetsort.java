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
public class Aktivitaetsort implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Aktivitaetsort")
	private int id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@Column (name = "Aktivität_ID")
	Aktivitaet aktivitaet;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@Column (name = "Ort_ID")
	Ort ort;

//	public Aktivitaetsort() {
//
//	}
	
	public Aktivitaetsort(Aktivitaet aktivitaet, Ort ort) {
		
		this.aktivitaet = aktivitaet;
		this.ort =ort;
		
		PersistenceManager pm=PersistenceManager.getPersistenceManager();
		pm.create(this);
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
		return "ID: " + id + "Aktivität: " + aktivitaet + "Ort: " + ort;
	}

}
