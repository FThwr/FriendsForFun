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
import de.hwrberlin.FriendsForFun.persistence.entities.Kategorie;
import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.manager.AktivitaetManager;
import de.hwrberlin.FriendsForFun.persistence.manager.EventManager;
import de.hwrberlin.FriendsForFun.persistence.manager.KategorieManager;

@Controller
@SessionAttributes("nutzer")
public class NewEventController {

	@Autowired
	private EventManager eventManager;

	@Autowired
	private KategorieManager kategorieManager;
	
	@Autowired
	private AktivitaetManager aktivitaetManager;


	@PostMapping("/neues_event.html")
	public String addEvent(@ModelAttribute("event") Event event, @ModelAttribute ("nutzer") Nutzer nutzer, BindingResult result) {
		try {
			event.setZeitpunkt(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(event.getZeitpunktHelper()));
		} catch (ParseException e) {
			System.out.println("Kann Datumsformat nicht verarbeiten: " + event.getZeitpunktHelper());
		}
		eventManager.createObject(event);
		return "erfolgreich_event.html";
	}

	@GetMapping("/neues_event.html")
	public String addEvent(Model model) {
		model.addAttribute("event", new Event());
		return "neues_event.html";
	}
	
	@ModelAttribute("kategorien")
	public List<Kategorie> getKategorien(){
		return kategorieManager.getKategorien();
	}

	
	@ModelAttribute("aktivitaeten")
	public List<Aktivitaet> getAktivitaeten(){
		return aktivitaetManager.getAktivitaeten();
	}
	
	@ModelAttribute("aktivitaetenListe")
	public String getAktivitaetenJSON(){
		return "var aktivitaetenListe = " + aktivitaetManager.getAktivitaetenJSON() + ";";
	}
	
}
