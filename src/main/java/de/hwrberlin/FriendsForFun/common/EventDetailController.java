package de.hwrberlin.FriendsForFun.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventDetailController {

	@GetMapping("/detailevent.html")
	public String addDetails(Model model) {
		return "detailevent.html";
	}

}
