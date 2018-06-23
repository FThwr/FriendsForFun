package de.hwrberlin.FriendsForFun.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hwrberlin.FriendsForFun.persistence.entities.Aktivitaet;
import de.hwrberlin.FriendsForFun.persistence.entities.Event;
import de.hwrberlin.FriendsForFun.persistence.entities.Eventteilnehmer;
import de.hwrberlin.FriendsForFun.persistence.entities.Kategorie;
import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.entities.Ort;
import de.hwrberlin.FriendsForFun.persistence.manager.AktivitaetManager;
import de.hwrberlin.FriendsForFun.persistence.manager.EventManager;
import de.hwrberlin.FriendsForFun.persistence.manager.EventteilnehmerManager;
import de.hwrberlin.FriendsForFun.persistence.manager.KategorieManager;
import de.hwrberlin.FriendsForFun.persistence.manager.OrtManager;

//definiert Klasse als Controller
@Controller

/**
 * macht es möglich, dass der angemeldete Nutzer als Organisator später
 * eingetragen werden kann
 */
@SessionAttributes("nutzer")
public class NewEventController {

	// lässt den Zugriff auf den Eventmanager zu
	@Autowired
	private EventManager eventManager;

	// lässt den Zugriff auf den Ortmanager zu
	@Autowired
	private OrtManager ortManager;

	// lässt den Zugriff auf den Eventteilnehmermanager zu
	@Autowired
	private EventteilnehmerManager eventteilnehmerManager;

	// lässt den Zugriff auf den Kategoriemanager zu
	@Autowired
	private KategorieManager kategorieManager;

	// lässt den Zugriff auf den Aktivitaetmanager zu
	@Autowired
	private AktivitaetManager aktivitaetManager;

	/**
	 * erstellt ein neues Event, trägt den angemeldeten Nutzer als Organisator (1.
	 * Teilnehmer) ein, passt das Datumsformat an und leitet zur Seite der
	 * erfolgreichen Erstellung eines Event weiter
	 */
	@PostMapping("/neues_event.html")
	public String addEvent(@ModelAttribute("event") Event event, @ModelAttribute("nutzer") Nutzer nutzer,
			BindingResult result) {
		try {
			event.setZeitpunkt(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(event.getZeitpunktHelper()));
		} catch (ParseException e) {
			System.out.println("Kann Datumsformat nicht verarbeiten: " + event.getZeitpunktHelper());
		}
		event.setNutzer(nutzer);
		eventManager.createObject(event);
		Eventteilnehmer teilnehmer = new Eventteilnehmer(event, nutzer);
		return "erfolgreich_event.html";
	}

	// lädt den Inhalt der Eventerstellung-Seite, sobald sie aufgerufen wird
	@GetMapping("/neues_event.html")
	public String addEvent(Model model) {
		model.addAttribute("event", new Event());
		return "neues_event.html";
	}

	/**
	 * erlaubt bei der Erstellung des Events die Auswahl einer Kategorie, die
	 * existiert
	 */
	@ModelAttribute("kategorien")
	public List<Kategorie> getKategorien() {
		return kategorieManager.getKategorien();
	}

	// erlaubt bei der Erstellung des Events die Auswahl eines Orts, der existiert
	@ModelAttribute("orte")
	public List<Ort> getOrte() {
		return ortManager.getOrte();
	}

	/**
	 * erlaubt bei der Erstellung des Events die Auswahl einer Aktivität, die
	 * existiert
	 */
	@ModelAttribute("aktivitaeten")
	public List<Aktivitaet> getAktivitaeten() {
		return aktivitaetManager.getAktivitaeten();
	}

	/**
	 * baut Variable aus den zurückgegebenen Aktivitäten zu einem String, sodass
	 * ein, für JSON lesbares, Objetkt entsteht
	 */
	@ModelAttribute("aktivitaetenListe")
	public String getAktivitaetenJSON() {
		return "var aktivitaetenListe = " + aktivitaetManager.getAktivitaetenJSON() + ";";
	}

}
