package de.hwrberlin.FriendsForFun.persistence.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import de.hwrberlin.FriendsForFun.persistence.manager.EventteilnehmerManager;

@Entity
public class Eventteilnehmer implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Eventteilnehmer")
	private int id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Event_ID")
	Event event;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Nutzer_ID")
	Nutzer nutzer;

	public Eventteilnehmer() {

	}

	public Eventteilnehmer(Event event, Nutzer nutzer) {

		this.event = event;
		this.nutzer = nutzer;

		EventteilnehmerManager etm = new EventteilnehmerManager();
		etm.createObject(this);
		// PersistenceManager pm=PersistenceManager.getPersistenceManager();
		// pm.create(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Nutzer getNutzer() {
		return nutzer;
	}

	public void setNutzer(Nutzer nutzer) {
		this.nutzer = nutzer;
	}

	@Override
	public String toString() {
		return "ID: " + id + "Event: " + event + "Nutzer: " + nutzer;
	}

}