package de.hwrberlin.FriendsForFun.persistence.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import de.hwrberlin.FriendsForFun.persistence.PersistenceManager;

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
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn (name = "Ort_ID")
	Ort ort;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn (name = "Aktivitaet_ID")
	Aktivitaet aktivitaet;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn (name = "Status_ID")
	Status status;
	
	@OneToMany(mappedBy = "event")
	Set<Eventteilnehmer> eventteilnehmer;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn (name = "Organisator")
	Nutzer nutzer;
	
	@OneToMany(mappedBy = "event")
	Set<Meldung> meldung;


	public Event() {

	}

	public Event (Date zeitpunkt, String beschreibung, Ort ort, Aktivitaet aktivitaet, Status status, Nutzer nutzer) {

		this.zeitpunkt = zeitpunkt;
		this.beschreibung = beschreibung;
		this.ort = ort;
		this.aktivitaet = aktivitaet;
		this.status = status;
		this.nutzer = nutzer;

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
	
	public Ort getOrt() {
		return ort;
	}

	public void setOrt(Ort ort) {
		this.ort = ort;
	}

	public Aktivitaet getAktivitaet() {
		return aktivitaet;
	}

	public void setAktivitaet(Aktivitaet aktivitaet) {
		this.aktivitaet = aktivitaet;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Nutzer getNutzer() {
		return nutzer;
	}

	public void setNutzer(Nutzer nutzer) {
		this.nutzer = nutzer;
	}

	public Set<Eventteilnehmer> getEventteilnehmer() {
		return eventteilnehmer;
	}

	public void setEventteilnehmer(Set<Eventteilnehmer> eventteilnehmer) {
		this.eventteilnehmer = eventteilnehmer;
	}

	public Set<Meldung> getMeldung() {
		return meldung;
	}

	public void setMeldung(Set<Meldung> meldung) {
		this.meldung = meldung;
	}

	@Override
	public String toString() {
		return "ID: " + id;
	}

}