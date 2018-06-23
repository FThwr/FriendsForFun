package de.hwrberlin.FriendsForFun.common;

import javax.persistence.NoResultException;

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

//definiert Klasse als Controller
@Controller
public class NewPlaceController {

	// lässt den Zugriff auf den Ortmanager zu
	@Autowired
	private OrtManager ortManager;

	/**
	 * erstellt einen Ort, sofern er in der Kombination Bezeichnung, Postleitzahl
	 * und Straße nicht existiert und leitet zur Seite der erfolgreichen
	 * Ortserstellung weiter
	 */
	@PostMapping("/neuer_ort.html")
	public String addOrt(@ModelAttribute("ort") Ort ort, BindingResult result) {
		try {
			ortManager.getOrte(ort.getBez_ort(), ort.getPlz(), ort.getStrasse());
			return "fehlermeldung_neuer_ort.html";
		} catch (NoResultException e) {
			ortManager.createObject(ort);

			return "erfolgreich_ort.html";
		}
	}

	// lädt den Inhalt der Orterstellung-Seite sobald sie aufgerufen wird
	@GetMapping("/neuer_ort.html")
	public String addOrt(Model model) {
		model.addAttribute("ort", new Ort());
		return "neuer_ort.html";
	}

}
