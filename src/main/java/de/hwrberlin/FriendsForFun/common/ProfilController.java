
package de.hwrberlin.FriendsForFun.common;

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

	@Autowired
	private NutzerManager nutzerManager;

	@RequestMapping("/profil.html")
	public String index(Model model) {
		return "profil.html";
	}

	@GetMapping("/profil.html")
	public Nutzer getAktivNutzer(@ModelAttribute("nutzer") Nutzer nutzer, BindingResult result, Model model) {
		return nutzerManager.getNutzer(nutzer.getUsername(), nutzer.getPasswort()) /* .get(1) */;
	}

	@PostMapping("/profil.html")
	public String changeUsersettings(@ModelAttribute("nutzer") Nutzer nutzer,
			@ModelAttribute("passwort") String password, @ModelAttribute("username") String username, @ModelAttribute("mail") String mail,
			BindingResult result, Model model) {
		if (!password.isEmpty()) {
			nutzer.setPasswort(password);
		}
		if (!username.isEmpty()) {
			nutzer.setUsername(username);
		}
		if(!mail.isEmpty()) {
			nutzer.setMail(mail);
		}
		if (!username.isEmpty() || !password.isEmpty() || !mail.isEmpty()) {
			nutzerManager.saveObject(nutzer);
		}
		return "redirect:/homepage.html";
	}
}