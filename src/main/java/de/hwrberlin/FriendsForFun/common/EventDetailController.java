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
	public String details(@ModelAttribute("id") int id, Model model) {
		System.out.println("Event: " + eventManager.getEventById(id));
		model.addAttribute("event", eventManager.getEventById(id));
		return "detailevent.html";
	}

}