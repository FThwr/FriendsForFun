package de.hwrberlin.friendsforfun.persistence.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy = "ort")
	Set<Aktivitaetsort> aktivitaetsort;
	
	@OneToMany(mappedBy = "ort")
	Set<Event> event;
	
	@OneToMany(mappedBy = "ort")
	Set<Meldung> meldung;


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
	
	public Set<Aktivitaetsort> getAktivitaetsort() {
		return aktivitaetsort;
	}

	public void setAktivitaetsort(Set<Aktivitaetsort> aktivitaetsort) {
		this.aktivitaetsort = aktivitaetsort;
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
		return "ID: " + id + "; Ort: " + bez_ort;
	}

}