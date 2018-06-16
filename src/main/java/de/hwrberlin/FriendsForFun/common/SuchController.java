package de.hwrberlin.FriendsForFun.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.hwrberlin.FriendsForFun.persistence.entities.Aktivitaet;
import de.hwrberlin.FriendsForFun.persistence.entities.Event;
import de.hwrberlin.FriendsForFun.persistence.entities.Kategorie;
import de.hwrberlin.FriendsForFun.persistence.entities.Ort;
import de.hwrberlin.FriendsForFun.persistence.manager.AktivitaetManager;
import de.hwrberlin.FriendsForFun.persistence.manager.EventManager;
import de.hwrberlin.FriendsForFun.persistence.manager.KategorieManager;
import de.hwrberlin.FriendsForFun.persistence.manager.OrtManager;

@Controller
public class SuchController {

	@Autowired
	private OrtManager ortManager;

	@Autowired
	private EventManager eventManager;

	@Autowired
	private KategorieManager kategorieManager;

	@Autowired
	private AktivitaetManager aktivitaetManager;

	@ModelAttribute("kategorien")
	public List<Kategorie> getKategorien() {
		return kategorieManager.getKategorien();
	}

	@ModelAttribute("aktivitaeten")
	public List<Aktivitaet> getAktivitaeten() {
		return aktivitaetManager.getAktivitaeten();
	}

	@ModelAttribute("aktivitaetenListe")
	public String getAktivitaetenJSON() {
		return "var aktivitaetenListe = " + aktivitaetManager.getAktivitaetenJSON() + ";";
	}

	@ModelAttribute("orte")
	public List<Ort> getOrte() {
		return ortManager.getOrte();
	}

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

	@RequestMapping("/suche.html")
	public String addSuche(Model model) {
		return "suche.html";
	}

}
