package de.hwrberlin.friendsforfun.persistence.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.hwrberlin.friendsforfun.persistence.PersistenceManager;

@Entity
public class Event implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Event")
	private int id;

	@Column(name = "Zeitpunkt")
	Date zeitpunkt;
	
	@Column (name = "Beschreibung")
	String beschreibung;


	public Event() {

	}

	public Event (Date zeitpunkt, String beschreibung) {

		this.zeitpunkt = zeitpunkt;
		this.beschreibung = beschreibung;

		PersistenceManager pm = PersistenceManager.getPersistenceManager();
		pm.create(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getZeitpunkt() {
		return zeitpunkt;
	}

	public void setZeitpunkt(Date zeitpunkt) {
		this.zeitpunkt = zeitpunkt;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	@Override
	public String toString() {
		return "ID: " + id;
	}

}