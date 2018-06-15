package de.hwrberlin.FriendsForFun.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.hwrberlin.FriendsForFun.persistence.entities.Aktivitaet;
import de.hwrberlin.FriendsForFun.persistence.entities.Event;
import de.hwrberlin.FriendsForFun.persistence.entities.Kategorie;
import de.hwrberlin.FriendsForFun.persistence.manager.AktivitaetManager;
import de.hwrberlin.FriendsForFun.persistence.manager.EventManager;
import de.hwrberlin.FriendsForFun.persistence.manager.KategorieManager;

@Controller
public class NewActivityController {

	@Autowired
	private AktivitaetManager aktivitaetManager;

	@Autowired
	private KategorieManager kategorieManager;
	
	@PostMapping("/neue_aktivitaet.html")
	public String addAktivitaet(@ModelAttribute("aktivitaet") Aktivitaet aktivitaet, BindingResult result) {
		aktivitaetManager.createObject(aktivitaet);
		return "erfolgreich_aktivitaet.html";
	}
	

	@GetMapping("/neue_aktivitaet.html")
	public String addEvent(Model model) {
		model.addAttribute("aktivitaet", new Aktivitaet());
		return "neue_aktivitaet.html";
	}
	
	@ModelAttribute("kategorien")
	public List<Kategorie> getKategorien(){
		return kategorieManager.getKategorien();
	}

}
