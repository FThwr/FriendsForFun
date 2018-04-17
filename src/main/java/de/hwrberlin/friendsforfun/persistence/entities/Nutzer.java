package de.hwrberlin.friendsforfun.persistence.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import de.hwrberlin.friendsforfun.persistence.PersistenceManager;

@Entity
public class Nutzer implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Nutzer")
	private int id;

	@Column(name = "EMail")
	String mail;

	@Column(name = "Username")
	String username;

	@Column(name = "Geburtsdatum")
	Date geburtsdatum;

	@Column(name = "Geschlecht")
	char geschlecht;

	@Column(name = "Passwort")
	String passwort;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@Column (name = "Status_ID")
	Status status;
	
	@OneToMany(mappedBy = "nutzer")
	Set<Eventteilnehmer> eventteilnehmer;
	
	@OneToMany(mappedBy = "nutzer")
	Set<Event> event;
	
	@OneToMany(mappedBy = "nutzer")
	Set<Meldung> meldung;
	

	public Nutzer() {

	}

	public Nutzer(String mail, String username, Date geburtsdatum, char geschlecht, String passwort, Status status) {

		this.mail = mail;
		this.username = username;
		this.geburtsdatum = geburtsdatum;
		this.geschlecht = geschlecht;
		this.passwort = passwort;
		this.status = status;

		PersistenceManager pm = PersistenceManager.getPersistenceManager();
		pm.create(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public char getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(char geschlecht) {
		this.geschlecht = geschlecht;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Eventteilnehmer> getEventteilnehmer() {
		return eventteilnehmer;
	}

	public void setEventteilnehmer(Set<Eventteilnehmer> eventteilnehmer) {
		this.eventteilnehmer = eventteilnehmer;
	}

	public Set<Event> getEvent() {
		return event;
	}

	public void setEvent(Set<Event> event) {
		this.event = event;
	}

	public Set<Meldung> getMeldung() {
		return meldung;
	}

	public void setMeldung(Set<Meldung> meldung) {
		this.meldung = meldung;
	}

	@Override
	public String toString() {
		return "ID: " + id + "; Username: " + username;
	}
}