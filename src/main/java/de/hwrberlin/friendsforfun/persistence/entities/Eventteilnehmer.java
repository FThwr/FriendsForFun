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
public class Eventteilnehmer implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Eventteilnehmer")
	private int id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	Event event;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	Nutzer nutzer;

//	public Eventteilnehmer() {
//
//	}
	
	public Eventteilnehmer() {
		PersistenceManager pm=PersistenceManager.getPersistenceManager();
		pm.create(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ID: " + id;
	}

}