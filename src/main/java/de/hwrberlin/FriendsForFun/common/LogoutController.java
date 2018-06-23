package de.hwrberlin.FriendsForFun.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//definiert Klasse als Controller
@Controller
public class LogoutController {

	// lädt den Inhalt der Logout-Seite, sobald sie aufgerufen wird
	@RequestMapping("/logout.html")
	public String logout(Model model) {
		return "logout.html";
	}

}
