
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

@Controller
@SessionAttributes("nutzer")
public class ProfilController {

	static String message;
	static int counter;

	@Autowired
	private NutzerManager nutzerManager;

	@GetMapping("/profil.html")
	public Nutzer getAktivNutzer(@ModelAttribute("nutzer") Nutzer nutzer, BindingResult result, Model model) {
		System.out.println("counter: " + counter + message);
		if (counter == 1) {
			message = "Änderungen erfolgreich!";
		}
		if (counter == 2) {
			message = "Username konnte nicht geändert werden, da er bereits existiert!";
		}
		if (counter == 0) {
			message = "";
		}
		model.addAttribute("myMessage", message);
		counter = 0;
		return nutzerManager.getNutzer(nutzer.getUsername(), nutzer.getPasswort()) /* .get(1) */;

	}

	@PostMapping("/profil.html")
	public String changeUsersettings(@ModelAttribute("nutzer") Nutzer nutzer,
			@ModelAttribute("passwort") String password, @ModelAttribute("user") String username,
			@ModelAttribute("mail") String mail, BindingResult result, Model model) {
		counter = 1;
		if (!password.isEmpty()) {
			nutzer.setPasswort(password);
		}
		if (!username.isEmpty()) {
			try {
				nutzerManager.getNutzer(username);
				counter = 2;
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