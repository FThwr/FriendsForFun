package de.hwrberlin.FriendsForFun.common;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.manager.NutzerManager;

// definiert Klasse als Controller
@Controller

/**
 * macht es möglich, dass der neue Nutzer als angemeldeter Nutzer für die
 * Session gespeichert wird
 */
@SessionAttributes("nutzer")
public class NewUserController {

	// lässt den Zugriff auf den Nutzermanager zu
	@Autowired
	private NutzerManager nutzerManager;

	/**
	 * erstellt einen neuen Nutzer, sofern der Nutzername nicht beriets vergeben ist
	 * und leitet zum Profil weiter, sofern die Erstellung erfolgreich weiter
	 */
	@PostMapping("/neuer_nutzer.html")
	public String addNutzer(@ModelAttribute("nutzer") Nutzer nutzer, BindingResult result) {
		try {
			nutzerManager.getNutzer(nutzer.getUsername());
			return "fehlermeldung_neuer_nutzer.html";

		} catch (NoResultException e) {
			nutzerManager.createObject(nutzer);
			System.out.println("should now add user '" + nutzer.getUsername() + "'");
			return "redirect:/profil.html";
		}

	}

	// lädt den Inhalt der Nutzererstellung-Seite, wenn sie aufgerufen wird
	@GetMapping("/neuer_nutzer.html")
	public String addNutzer(Model model) {
		model.addAttribute("nutzer", new Nutzer());
		return "neuer_nutzer.html";
	}

}
