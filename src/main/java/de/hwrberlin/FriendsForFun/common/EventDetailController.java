package de.hwrberlin.FriendsForFun.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hwrberlin.FriendsForFun.persistence.entities.Event;
import de.hwrberlin.FriendsForFun.persistence.manager.EventManager;

@Controller
@SessionAttributes("event")
public class EventDetailController {
	
	@Autowired
	EventManager eventManager;

	@RequestMapping("/detailevent.html")
	public String details(Model model) {
		return "detailevent.html";
	}

	@GetMapping("/detailevent.html")
	public Event getDetails(@ModelAttribute("event") Event event, BindingResult result, Model model) {
		return eventManager.getEventById(event.getId());
	}
}