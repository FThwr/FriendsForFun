package de.hwrberlin.friendsforfun.persistence.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import de.hwrberlin.friendsforfun.persistence.PersistenceManager;

@Entity
@Inheritance
@DiscriminatorColumn(name = "BENUTZER_TYPE")
public class Benutzer implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Benutzer")
	private int id;

	@Column(name = "EMail")
	String mail;

	@Column(name = "Name")
	String name;

	@Column(name = "Vorname")
	String vorname;

	@Column(name = "Benutzername")
	String benutzername;

	@Column(name = "Passwort")
	String passwort;

	public Benutzer() {

	}

	public Benutzer(String mail, String name, String vorname, String benutzername, String passwort) {

		this.mail = mail;
		this.name = name;
		this.vorname = vorname;
		this.benutzername = benutzername;
		this.passwort = passwort;

		PersistenceManager pm = PersistenceManager.getPersistenceManager();
		pm.create(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public int getId() {
		return id;
	}

	public String getMail() {
		return mail;
	}

	public String getBenutzername() {
		return benutzername;
	}

	@Override
	public String toString() {
		return "ID: " + id + "; Name: " + name + "; Vorname: " + vorname + "; E-Mail: " + mail + "; Username: " + benutzername;
	}

}