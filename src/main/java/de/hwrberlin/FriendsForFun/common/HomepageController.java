package de.hwrberlin.FriendsForFun.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hwrberlin.FriendsForFun.persistence.entities.Event;
import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.manager.EventManager;

//definiert Klasse als Controller
@Controller

/**
 * macht es möglich, dass zu dem angemeldeten Nutzer die Daten ausgelesen werden
 * können
 */
@SessionAttributes("nutzer")
public class HomepageController {

	// lässt den Zugriff auf den Eventmanager zu
	@Autowired
	private EventManager eventManager;

	/**
	 * sobald die Homepage aufgerufen wird werden alle Events zu dem Nutzer
	 * herausgefunden
	 */
	@GetMapping("/homepage.html")
	@ModelAttribute("events")
	public List<Event> getEventsByNutzer(@ModelAttribute("nutzer") Nutzer nutzer, BindingResult result, Model model) {
		return eventManager.getEventsByNutzer(nutzer);
	}

	/**
	 * nachdem eine ID auf der Homepage eingegeben wurde, wird das Event anhand der
	 * ID gefunden und die Teilnehmeranzahl für das Event berechnet und schließlich
	 * auf der Detailseite alles angezeigt
	 */
	@PostMapping("/detailevent.html")
	public String details(@ModelAttribute("id") int id, @ModelAttribute("event") Event event, Model model) {
		model.addAttribute("event", eventManager.getEventById(id));
		model.addAttribute("anzahl", eventManager.getAnzahlTeilnehmer(event));
		return "detailevent.html";
	}

}