package de.hwrberlin.FriendsForFun.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.entities.Ort;
import de.hwrberlin.FriendsForFun.persistence.manager.NutzerManager;
import de.hwrberlin.FriendsForFun.persistence.manager.OrtManager;

@Controller
public class NewPlaceController {

	@Autowired
	private OrtManager ortManager;

	@PostMapping("/ort/add")
	public String addOrt(@ModelAttribute("ort") Ort ort, BindingResult result) {
		ortManager.createObject(ort);
		return "homepage.html";
	}

	@GetMapping("/neuer_ort.html")
	public String addOrt(Model model) {
		model.addAttribute("ort", new Ort());
		return "neuer_ort";
	}
	
}
