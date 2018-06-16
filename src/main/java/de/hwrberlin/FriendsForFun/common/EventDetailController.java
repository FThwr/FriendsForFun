package de.hwrberlin.FriendsForFun.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hwrberlin.FriendsForFun.persistence.entities.Event;

@Controller
@RequestMapping("/suchergebnisse.html")
@SessionAttributes("event")
public class EventDetailController {

	@RequestMapping("/detailevent.html")
	public String details(Model model) {
		model.addAttribute("event", new Event());
		return "detailevent.html";
	}

	@GetMapping("/detailevent.html")
	public Event getDetails(/*@SessionAttribute("event") */ @ModelAttribute("event") Event event, BindingResult result, Model model) {
		return event;
	}
}