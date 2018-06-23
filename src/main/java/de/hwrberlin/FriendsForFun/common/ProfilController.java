
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

import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.manager.NutzerManager;

//definiert Klasse als Controller
@Controller

/**
 * macht es möglich, dass Daten zum angemeldeten Nutzer der Session angezeigt
 * werden können und dieser Nutzer verändert werdne kann
 */
@SessionAttributes("nutzer")
public class ProfilController {

	// Variable zur Bestimmung welche Message ausgegeben wird
	static String message;

	// Variable zur Bestimmung welcher Änderungsfall eintritt
	static int option;

	// lässt den Zugriff auf den Nutzermanager zu
	@Autowired
	private NutzerManager nutzerManager;

	/**
	 * lädt alle Informationen zum angemeldeten Nutzer, wenn das Profil aufgerufen
	 * wird und gibt je nach Änderungsfall eine spezielle Message aus
	 */
	@GetMapping("/profil.html")
	public Nutzer getAktivNutzer(@ModelAttribute("nutzer") Nutzer nutzer, BindingResult result, Model model) {
		if (option == 1) {
			message = "Änderungen erfolgreich!";
		}
		if (option == 2) {
			message = "Username konnte nicht geändert werden, da er bereits existiert!";
		}
		if (option == 0) {
			message = "";
		}
		model.addAttribute("myMessage", message);
		option = 0;
		return nutzerManager.getNutzer(nutzer.getUsername(), nutzer.getPasswort()) /* .get(1) */;

	}

	/**
	 * sollte etwas geändert werden wird das gespeichert,jedoch bei Änderung des
	 * Nutzernamens zu einen Namen, den ein Nutzer bereits hat, wird der Name nicht
	 * geändert
	 */
	@PostMapping("/profil.html")
	public String changeUsersettings(@ModelAttribute("nutzer") Nutzer nutzer,
			@ModelAttribute("passwort") String password, @ModelAttribute("user") String username,
			@ModelAttribute("mail") String mail, BindingResult result, Model model) {
		option = 1;
		if (!password.isEmpty()) {
			nutzer.setPasswort(password);
		}
		if (!username.isEmpty()) {
			try {
				nutzerManager.getNutzer(username);
				option = 2;
			} catch (NoResultException e) {
				nutzer.setUsername(username);
			}
		}
		if (!mail.isEmpty()) {
			nutzer.setMail(mail);
		}
		if (!username.isEmpty() || !password.isEmpty() || !mail.isEmpty()) {

			nutzerManager.saveObject(nutzer);
		}
		return "redirect:/profil.html";
	}
}