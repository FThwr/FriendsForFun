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

import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.manager.NutzerManager;

@Controller
public class LoginController {

	@Autowired
	private NutzerManager nutzerManager;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("nutzer", new Nutzer());
		return "index.html";
	}

	@PostMapping("/index.html")
	public String login(@ModelAttribute("nutzer") Nutzer nutzer, BindingResult result, Model model) {
		try {
			nutzerManager.getNutzer(nutzer.getUsername(), nutzer.getPasswort());
			return "homepage.html/" + nutzer.toString();
		} catch (NoResultException e) {
			return "login.html";
		}

	}
}