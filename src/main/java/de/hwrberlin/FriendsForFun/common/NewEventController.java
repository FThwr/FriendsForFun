package de.hwrberlin.FriendsForFun.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.hwrberlin.FriendsForFun.persistence.entities.Event;
import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.manager.EventManager;
import de.hwrberlin.FriendsForFun.persistence.manager.NutzerManager;

@Controller
public class NewEventController {

	@Autowired
	private EventManager eventManager;

	@PostMapping("/event/add")
	public String addEvent(@ModelAttribute("event") Event event, BindingResult result) {
		eventManager.createObject(event);
		return "homepage.html";
	}

	@GetMapping("/neues_event.html")
	public String addEvent(Model model) {
		model.addAttribute("event", new Event());
		return "neues_event";
	}
}
