package de.hwrberlin.FriendsForFun.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@ModelAttribute("altersempfehlung")
	public int altersempfehlung() {
		return 0;
	}

	@PostMapping("/suchergebnisse.html")
	public String addSuchergebnisse(@ModelAttribute("aktivitaet") int aktivitaet,
			@ModelAttribute("kategorie") int kategorie, Model model, BindingResult result) {
		List<Event> ergebnisse = new ArrayList<Event>();
		if (aktivitaet != 0) {
			ergebnisse = eventManager.getEventsByAktivitaet(aktivitaet);
		} else if (kategorie != 0) {
			ergebnisse = eventManager.getEventsByKategorie(kategorie);
		}
		model.addAttribute("ergebnisse", ergebnisse);
		return "suchergebnisse.html";
	}

	@RequestMapping("/suche.html")
	public String addSuche(Model model) {
		return "suche.html";
	}

}
