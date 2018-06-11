package de.hwrberlin.FriendsForFun.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.manager.NutzerManager;

@Controller
public class ProfilController {

	@Autowired
	private NutzerManager nutzermanager;
	
	@RequestMapping({"/profil.html"})
    public String index(Model model){
        return "profil";
    }
	
	@GetMapping("/profil.html")
    @ModelAttribute("aktiver_nutzer")
    public Nutzer getAktivNutzer() {
    	return nutzermanager.getNutzer().get(1);
    }
	
}
