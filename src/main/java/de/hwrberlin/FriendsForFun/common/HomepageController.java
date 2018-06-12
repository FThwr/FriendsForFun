package de.hwrberlin.FriendsForFun.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import de.hwrberlin.FriendsForFun.persistence.entities.Event;
import de.hwrberlin.FriendsForFun.persistence.manager.EventManager;

@Controller
public class HomepageController {

	@Autowired
	private EventManager eventmanager;
	
    @RequestMapping({"/homepage.html"})
    public String index(Model model){
        return "homepage.html";
    }

    @GetMapping("/homepage.html")
    @ModelAttribute("events")
    public List<Event> getEvents() {
    	return eventmanager.getEvents();
    }
    
}