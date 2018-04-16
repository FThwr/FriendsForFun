package de.hwrberlin.friendsforfun.persistence.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import de.hwrberlin.friendsforfun.persistence.PersistenceManager;

@Entity
public class Aktivitaet implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Aktivitaet")
	private int id;

	@Column(name = "Bez_Aktivitaet")
	String bez_aktivitaet;

	@Column(name = "Min_PersAnzahl")
	int min_persanzahl;
	
	@Column(name = "Max_PersAnzahl")
	int max_persanzahl;

	@Column(name = "Altersempfehlung")
	int altersempfehlung;

	@Column(name = "Beschreibung")
	String beschreibung;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@Column (name = "Status_ID")
	Status status;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@Column (name = "Kategorie_ID")
	Kategorie kategorie;
	
	@OneToMany(mappedBy = "aktivitaet")
	Set<Aktivitaetsort> aktivitaetsort;
	
	@OneToMany(mappedBy = "aktivitaet")
	Set<Event> event;
	
	@OneToMany(mappedBy = "aktivitaet")
	Set<Meldung> meldung;

	public Aktivitaet() {

	}

	public Aktivitaet (String bez_aktivitaet, int min_persanzahl, int max_persanzahl, int altersempfehlung, String beschreibung, Status status, Kategorie kategorie) {

		this.bez_aktivitaet = bez_aktivitaet;
		this.min_persanzahl = min_persanzahl;
		this.max_persanzahl = max_persanzahl;
		this.altersempfehlung = altersempfehlung;
		this.beschreibung = beschreibung;
		this.status = status;
		this.kategorie = kategorie;

		PersistenceManager pm = PersistenceManager.getPersistenceManager();
		pm.create(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBez_aktivitaet() {
		return bez_aktivitaet;
	}

	public void setBez_aktivitaet(String bez_aktivitaet) {
		this.bez_aktivitaet = bez_aktivitaet;
	}

	public int getMin_persanzahl() {
		return min_persanzahl;
	}

	public void setMin_persanzahl(int min_persanzahl) {
		this.min_persanzahl = min_persanzahl;
	}

	public int getMax_persanzahl() {
		return max_persanzahl;
	}

	public void setMax_persanzahl(int max_persanzahl) {
		this.max_persanzahl = max_persanzahl;
	}

	public int getAltersempfehlung() {
		return altersempfehlung;
	}

	public void setAltersempfehlung(int altersempfehlung) {
		this.altersempfehlung = altersempfehlung;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Kategorie getKategorie() {
		return kategorie;
	}

	public void setKategorie(Kategorie kategorie) {
		this.kategorie = kategorie;
	}

	@Override
	public String toString() {
		return "ID: " + id + "; Aktivität: " + bez_aktivitaet;
	}

}