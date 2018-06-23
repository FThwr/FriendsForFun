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

//definiert Klasse als Controller
@Controller

// macht es möglich, dass Details zu dem Event angezeigt werden können
@SessionAttributes("event")
public class EventDetailController {
	
	//lässt den Zugriff auf den Eventmanager zu
	@Autowired
	EventManager eventManager;

	//öffnet die Details zu dem Event, welches auf der Homepage ausgewählt wird
	@RequestMapping("/detailevent.html")
	public String details(@ModelAttribute("id") int id, Model model) {
		model.addAttribute("event", eventManager.getEventById(id));
		return "detailevent.html";
	}

}