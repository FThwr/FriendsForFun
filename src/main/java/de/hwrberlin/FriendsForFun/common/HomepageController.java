package de.hwrberlin.FriendsForFun.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hwrberlin.FriendsForFun.persistence.entities.Event;
import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.manager.EventManager;

@Controller
@SessionAttributes("nutzer")
public class HomepageController {

	@Autowired
	private EventManager eventManager;

	@RequestMapping({ "/homepage.html" })
	public String index(Model model) {
		return "homepage.html";
	}

	@GetMapping("/homepage.html")
	@ModelAttribute("events")
	public List<Event> getEventsByNutzer(@ModelAttribute("nutzer") Nutzer nutzer, BindingResult result, Model model) {
		return eventManager.getEventsByNutzer(nutzer);
	}

}