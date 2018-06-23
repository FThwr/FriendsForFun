package de.hwrberlin.FriendsForFun;

import java.sql.Date;

import de.hwrberlin.FriendsForFun.persistence.entities.*;

public class App {

	@SuppressWarnings({ "deprecation" })
	public static void main(String[] args) {

		new Nutzer("tester@test.de", "Tester", new Date(75, 7, 13), 'm', "testpassword");
		
		Status status = new Status("aktiv");
		Status status2 = new Status("gemeldet");
		Status status3 = new Status("inaktiv");
		
		new Nutzer("abc@xyz.de", "abc123", new Date(110, 11, 21), 'w', "start-123");
		
		Nutzer sophia = new Nutzer("s_ruhkieck@stud.hwr-berlin.de", "Sophia", new Date(97, 1, 22), 'w', "password", status);
		Nutzer felicia = new Nutzer("s_tsakonas@stud.hwr-berlin.de", "Felicia", new Date(98, 8, 10), 'w', "password", status3);
		new Nutzer("s_menz@stud.hwr-berlin.de", "Max", new Date(98, 7, 16), 'm', "password", status);
		new Nutzer("s_guhlal@stud.hwr-berlin.de", "Alicia", new Date(98, 0, 16), 'w', "password", status2);
		
		Kategorie outdoor = new Kategorie("Outdoor-Aktivität");
		Kategorie sport = new Kategorie("Sport");
		Kategorie brett = new Kategorie("Brettspiele");
		Kategorie karten = new Kategorie("Kartenspiele");
		Kategorie gruppe = new Kategorie("Gruppenaktivität");
		Kategorie gesellschaft = new Kategorie("Gesellschaftsspiele");
		Kategorie musik = new Kategorie("Musik");
		
		new Aktivitaet("Tennis", 2, 4, 12, "---", status, sport);
		Aktivitaet lagerfeuer = new Aktivitaet("Lagerfeuer", 6, 30, 18, "Schönes Lagerfeuer am See", status, outdoor);
		
		Ort ort = new Ort("Lauter See", "10319", "Am See", "am Ostufer");
		
		Event event = new Event(new Date(118, 6, 14), "...", ort, lagerfeuer, status, felicia);

		new Eventteilnehmer(event, sophia);
		
		
				
	}

}
