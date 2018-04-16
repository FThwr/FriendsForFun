package de.hwrberlin.friendsforfun.persistence.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

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

	public Aktivitaet() {

	}

	public Aktivitaet (String bez_aktivitaet, int min_persanzahl, int max_persanzahl, int altersempfehlung, String beschreibung) {

		this.bez_aktivitaet = bez_aktivitaet;
		this.min_persanzahl = min_persanzahl;
		this.max_persanzahl = max_persanzahl;
		this.altersempfehlung = altersempfehlung;
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

	public String getBez_aktivitaet() {
		return bez_aktivitaet;
	}

	public void setBez_aktivitaet(String bez_aktivitaet) {
		this.bez_aktivitaet = bez_aktivitaet;
	}

	public String getMin_persanzahl() {
		return min_persanzahl;
	}

	public void setMin_persanzahl(String min_persanzahl) {
		this.min_persanzahl = min_persanzahl;
	}

	public String getMax_persanzahl() {
		return max_persanzahl;
	}

	public void setMax_persanzahl(String max_persanzahl) {
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

	@Override
	public String toString() {
		return "ID: " + id + "; Aktivität: " + bez_aktivitaet;
	}

}