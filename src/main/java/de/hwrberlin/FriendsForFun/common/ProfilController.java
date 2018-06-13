package de.hwrberlin.FriendsForFun.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.manager.NutzerManager;

@Controller
@SessionAttributes("nutzer")
public class ProfilController {

	@Autowired
	private NutzerManager nutzermanager;

	@RequestMapping("/profil.html")
	public String index(Model model) {
		return "profil.html";
	}

	@GetMapping("/profil.html")
	public Nutzer getAktivNutzer(@ModelAttribute("nutzer") Nutzer nutzer, BindingResult result, Model model) {
		return nutzermanager.getNutzer(nutzer.getUsername(), nutzer.getPasswort()) /* .get(1) */;
	}

}
