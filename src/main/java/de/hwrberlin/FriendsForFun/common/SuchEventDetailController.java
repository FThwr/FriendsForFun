package de.hwrberlin.FriendsForFun.common;

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

@Controller
@SessionAttributes(value = { "event", "nutzer" })
public class SuchEventDetailController {

	@Autowired
	EventManager eventManager;

	@Autowired
	EventteilnehmerManager eventteilnehmerManager;

	@RequestMapping("/detaileventSuche.html")
	public String details(@ModelAttribute("id") int id, Model model) {
		System.out.println("Event: " + eventManager.getEventById(id));
		model.addAttribute("event", eventManager.getEventById(id));
		return "detaileventSuche.html";
	}

	@PostMapping("/erfolgreich_teilnahme.html")
	public String addTeilnehmer(@ModelAttribute("nutzer") Nutzer nutzer, @ModelAttribute("event") Event event,
			BindingResult result) {
		Eventteilnehmer teilnehmer = new Eventteilnehmer(event, nutzer);
//		if (eventteilnehmerManager.isTeilnehmerAlreadyIn(event, nutzer)) {
//			System.out.println("Sie nehmen schon an diesem Event teil!");
//			return "fehlermeldung.html";
//		} else {
			eventteilnehmerManager.saveObject(teilnehmer);
			return "erfolgreich_teilnahme.html";
//		}
	}

}