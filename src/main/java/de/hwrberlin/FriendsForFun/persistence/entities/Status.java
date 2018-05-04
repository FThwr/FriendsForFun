package de.hwrberlin.FriendsForFun.persistence.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import de.hwrberlin.FriendsForFun.persistence.manager.StatusManager;

@Entity
public class Status implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Status")
	private int id;

	@Column(name = "Bez_Status")
	String bez_status;

	@OneToMany(mappedBy = "status")
	Set<Nutzer> nutzer;

	@OneToMany(mappedBy = "status")
	Set<Aktivitaet> aktivitaet;

	@OneToMany(mappedBy = "status")
	Set<Event> event;

	public Status() {

	}

	public Status(String bez_status) {

		this.bez_status = bez_status;

		StatusManager sm = new StatusManager();
		sm.createObject(this);
		// PersistenceManager pm = PersistenceManager.getPersistenceManager();
		// pm.create(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBez_status() {
		return bez_status;
	}

	public void setBez_status(String bez_status) {
		this.bez_status = bez_status;
	}

	public Set<Nutzer> getNutzer() {
		return nutzer;
	}

	public void setNutzer(Set<Nutzer> nutzer) {
		this.nutzer = nutzer;
	}

	public Set<Aktivitaet> getAktivitaet() {
		return aktivitaet;
	}

	public void setAktivitaet(Set<Aktivitaet> aktivitaet) {
		this.aktivitaet = aktivitaet;
	}

	public Set<Event> getEvent() {
		return event;
	}

	public void setEvent(Set<Event> event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return bez_status;
	}

}
