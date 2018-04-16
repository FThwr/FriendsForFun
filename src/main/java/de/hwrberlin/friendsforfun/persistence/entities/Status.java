package de.hwrberlin.friendsforfun.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.hwrberlin.friendsforfun.persistence.PersistenceManager;

@Entity
public class Status implements EntityInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Status")
	private int id;

	@Column(name = "Bez_Status")
	String bez_status;

	public Status() {

	}

	public Status (String bez_status) {

		this.bez_status = bez_status;

		PersistenceManager pm = PersistenceManager.getPersistenceManager();
		pm.create(this);
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

	@Override
	public String toString() {
		return "ID: " + id + "Status: " + bez_status;
	}

}
