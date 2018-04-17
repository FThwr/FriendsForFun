package de.hwrberlin.FriendsForFun;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.hwrberlin.FriendsForFun.persistence.PersistenceManager;
import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.entities.Status;

public class App {

	public static void main(String[] args) {

		Nutzer nutzer = new Nutzer("abc@xyz.de", "abc123", new Date(110, 11, 21), 'w', "start-123");

	}

}
