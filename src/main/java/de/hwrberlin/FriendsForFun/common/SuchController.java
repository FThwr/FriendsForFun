package de.hwrberlin.FriendsForFun.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import de.hwrberlin.FriendsForFun.persistence.entities.Aktivitaet;
import de.hwrberlin.FriendsForFun.persistence.entities.Kategorie;
import de.hwrberlin.FriendsForFun.persistence.entities.Ort;
import de.hwrberlin.FriendsForFun.persistence.manager.AktivitaetManager;
import de.hwrberlin.FriendsForFun.persistence.manager.KategorieManager;
import de.hwrberlin.FriendsForFun.persistence.manager.OrtManager;

@Controller
public class SuchController {

	@Autowired
	OrtManager ortManager;
	
	@Autowired
	private KategorieManager kategorieManager;
	
	@Autowired
	private AktivitaetManager aktivitaetManager;
	
	@ModelAttribute("kategorien")
	public List<Kategorie> getKategorien(){
		return kategorieManager.getKategorien();
	}

	
	@ModelAttribute("aktivitaeten")
	public List<Aktivitaet> getAktivitaeten(){
		return aktivitaetManager.getAktivitaeten();
	}
	
	@ModelAttribute("aktivitaetenListe")
	public String getAktivitaetenJSON(){
		return "var aktivitaetenListe = " + aktivitaetManager.getAktivitaetenJSON() + ";";
	}
	
	@ModelAttribute("orte")
	public List<Ort> getOrte(){
		return ortManager.getOrte();
	}
	
	@RequestMapping("/suche.html")
	public String addSuche(Model model) {
		return "suche.html";
	}

}
