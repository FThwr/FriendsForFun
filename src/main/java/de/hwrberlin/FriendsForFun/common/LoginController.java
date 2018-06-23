package de.hwrberlin.FriendsForFun.common;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.thymeleaf.exceptions.TemplateInputException;

import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.manager.NutzerManager;

//definiert Klasse als Controller
@Controller

/**
 * macht es möglich, dass der Nutzer als angemeldeter Nutzer gespeichert bleibt
 * für die Session
 */
@SessionAttributes("nutzer")
public class LoginController {

	// lässt den Zugriff auf den Nutzermanager zu
	@Autowired
	private NutzerManager nutzerManager;

	// lädt die Loginseite nach dem Start der Anwendung
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("nutzer", new Nutzer());
		return "index.html";
	}

	/**
	 * nachdem das Anmelden fehlgeschlagen ist und der Button zum erneuten ANmelden
	 * gedrückt wurde, wird die Loginseite erneut geladen
	 */
	@GetMapping("/index.html")
	public String loginpage(Model model) {
		model.addAttribute("nutzer", new Nutzer());
		return "index.html";
	}

	/**
	 * Überprüft, ob es einen Nutzer mit den Anmeldedaten gibt: wenn es einen gibt,
	 * dann wird er eingeloggt, wenn nicht, dass wird er zur Login-Fehlerseite
	 * wietergeleitet
	 */
	@PostMapping("/index.html")
	public String login(@ModelAttribute("nutzer") Nutzer nutzer, BindingResult result, Model model) {
		try {
			nutzerManager.getNutzer(nutzer.getUsername(), nutzer.getPasswort());
			return "redirect:/profil.html";
		} catch (NoResultException e) {
			return "fehlgeschlagen_login.html";
		}

	}
}
