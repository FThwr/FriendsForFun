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

@Controller
@SessionAttributes("nutzer")
public class LoginController {
	
	@Autowired
	private NutzerManager nutzerManager;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("nutzer", new Nutzer());
		return "index.html";
	}
	
	@GetMapping("/index.html")
	public String loginpage(Model model) {
		model.addAttribute("nutzer", new Nutzer());
		return "index.html";
	}

	@PostMapping("/index.html")
	public String login(@ModelAttribute("nutzer") Nutzer nutzer, BindingResult result, Model model) {
		try {
			nutzerManager.getNutzer(nutzer.getUsername(), nutzer.getPasswort());
			return "homepage.html";
		} catch (NoResultException e) {
			return "fehlgeschlagen_login.html";
		}

	}
}
