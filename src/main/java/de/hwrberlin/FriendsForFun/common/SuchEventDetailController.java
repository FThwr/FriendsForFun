package de.hwrberlin.FriendsForFun.common;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hwrberlin.FriendsForFun.persistence.entities.Event;
import de.hwrberlin.FriendsForFun.persistence.entities.Eventteilnehmer;
import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.manager.EventManager;
import de.hwrberlin.FriendsForFun.persistence.manager.EventteilnehmerManager;

//definiert Klasse als Controller
@Controller

/**
 * macht es möglich, dass der angemeldete Nutzer als Teilnehmer später
 * eingetragen werden kann zu dem Event, welches bei den Suchergebnissen
 * ausgewählt wurde
 */
@SessionAttributes(value = { "event", "nutzer" })
public class SuchEventDetailController {

	// lässt den Zugriff auf den Eventmanager zu
	@Autowired
	EventManager eventManager;

	// lässt den Zugriff auf den Eventteilnehmermanager zu
	@Autowired
	EventteilnehmerManager eventteilnehmerManager;

	/**
	 * findet zu dem ausgewähltem Event (welches anhand der ID ausgewählt wird) die
	 * entsprechenden Informationen und gibt außerdem die berechnete
	 * Teilnehmeranzahl aus
	 */
	@RequestMapping("/detaileventSuche.html")
	public String details(@ModelAttribute("id") int id, @ModelAttribute("event") Event event, Model model) {
		model.addAttribute("event", eventManager.getEventById(id));
		model.addAttribute("anzahl", eventManager.getAnzahlTeilnehmer(event));
		return "detaileventSuche.html";
	}

	/**
	 * fügt den angemeldeten Nutzer als teilnehmer hinzu, wenn dieser auf teilnehmen
	 * klickt und noch nicht an dem Event teilnimmt, wenn doch wird er zur Seite der
	 * fehlgeschlagenen Teilnahme weitergeleitet
	 */
	@PostMapping("/erfolgreich_teilnahme.html")
	public String addTeilnehmer(@ModelAttribute("nutzer") Nutzer nutzer, @ModelAttribute("event") Event event,
			BindingResult result) {
		try {
			eventteilnehmerManager.isTeilnehmerAlreadyIn(event, nutzer);
			System.out.println("Sie nehmen schon an diesem Event teil!");
			return "fehlermeldung_teilnehmen.html";
		} catch (NoResultException e) {
			Eventteilnehmer teilnehmer = new Eventteilnehmer(event, nutzer);
			eventteilnehmerManager.saveObject(teilnehmer);
			return "erfolgreich_teilnahme.html";
		}
	}

}