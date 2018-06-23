package de.hwrberlin.FriendsForFun.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hwrberlin.FriendsForFun.persistence.entities.Aktivitaet;
import de.hwrberlin.FriendsForFun.persistence.entities.Event;
import de.hwrberlin.FriendsForFun.persistence.entities.Kategorie;
import de.hwrberlin.FriendsForFun.persistence.entities.Ort;
import de.hwrberlin.FriendsForFun.persistence.manager.AktivitaetManager;
import de.hwrberlin.FriendsForFun.persistence.manager.EventManager;
import de.hwrberlin.FriendsForFun.persistence.manager.KategorieManager;
import de.hwrberlin.FriendsForFun.persistence.manager.OrtManager;

//definiert Klasse als Controller
@Controller

/**
 * macht es möglich, dass Events entsprechend der Suchanfrage ausgegeben werden
 * können
 */
@SessionAttributes("event")
public class SuchController {

	// lässt den Zugriff auf den Ortmanager zu
	@Autowired
	private OrtManager ortManager;

	// lässt den Zugriff auf den Eventmanager zu
	@Autowired
	private EventManager eventManager;

	// lässt den Zugriff auf den Kategoriemanager zu
	@Autowired
	private KategorieManager kategorieManager;

	// lässt den Zugriff auf den Aktivitätmanager zu
	@Autowired
	private AktivitaetManager aktivitaetManager;

	/**
	 * erlaubt bei der Erstellung des Events die Auswahl einer Kategorie, die
	 * existiert
	 */
	@ModelAttribute("kategorien")
	public List<Kategorie> getKategorien() {
		return kategorieManager.getKategorien();
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

	// erlaubt bei der Erstellung des Events die Auswahl eines Orts, der existiert
	@ModelAttribute("orte")
	public List<Ort> getOrte() {
		return ortManager.getOrte();
	}

	/**
	 * findet zu den eingegebenen Kriterien bei der Suchanfrage die entsprechenden
	 * Events und leitet den Nutzer zu den Ergebnissen weiter
	 */
	@PostMapping("/suchergebnisse.html")
	public String addSuchergebnisse(@RequestParam("aktivitaet") int aktivitaet,
			@RequestParam("kategorie") int kategorie,
			@RequestParam("altersempfehlung") Optional<Integer> altersempfehlung, @RequestParam("ort") int ort,
			@RequestParam("datum") String termin, Model model) {
		int alter = altersempfehlung.orElse(0);
		Date datum = null;
		try {
			datum = new SimpleDateFormat("yyyy-MM-dd").parse(termin);
		} catch (ParseException e) {
		}
		List<Event> ergebnisse = eventManager.getEventsBy(alter, kategorie, aktivitaet, datum, ort);
		model.addAttribute("ergebnisse", ergebnisse);
		return "suchergebnisse.html";
	}

	// lädt den Inhalt der Suchergebnis-Seite, sobald sie aufgerufen wird
	@GetMapping("/suchergebnisse.html")
	public Event getAusgewähltesEvent(@ModelAttribute("event") Event event, BindingResult result, Model model) {
		model.addAttribute("event", new Event());
		return event;
	}

	// lädt den Inhalt der Suchanfrage-Seite, wenn sie aufgerufen wird
	@RequestMapping("/suche.html")
	public String addSuche(Model model) {
		model.addAttribute("event", new Event());
		return "suche.html";
	}

}
