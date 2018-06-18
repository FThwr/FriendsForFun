package de.hwrberlin.FriendsForFun.common;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hwrberlin.FriendsForFun.persistence.entities.Nutzer;
import de.hwrberlin.FriendsForFun.persistence.manager.NutzerManager;

@Controller
@SessionAttributes("nutzer")
public class NewUserController {

	@Autowired
	private NutzerManager nutzerManager;

//	@GetMapping("/neuer_nutzer")
//	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
//			Model model) {
//		model.addAttribute("name", name);
//		return "neuer_nutzer";
//	}
//
//	 @RequestMapping(method=RequestMethod.POST, value="/nutzer/add")
//	 public String addNutzer(@ModelAttribute("nutzer") Nutzer nutzer,
//	 BindingResult result) {
//	 nutzerManager.addNutzer(nutzer);
//	
//	 return "redirect:/";
//	 }
//
//	@RequestMapping(method = RequestMethod.GET, value = "/nutzer/get")
//	public String getUser() {
//		return "" + nutzerManager.getNutzer().size();
//	}

	@PostMapping("/neuer_nutzer")
	public String addNutzer(@ModelAttribute ("nutzer") Nutzer nutzer, BindingResult result) {
		try {
			nutzerManager.getNutzer(nutzer.getUsername());
			return "fehlermeldung_neuer_nutzer.html";
		
		
		} catch (NoResultException e) {
			nutzerManager.createObject(nutzer);
			System.out.println("should now add user '" + nutzer.getUsername() + "'");
			return "redirect:/profil.html";
		}
		
		
	}
	
//	@PostMapping("/nutzer/add")
//	public ModelAndView addNutzer(@ModelAttribute Nutzer nutzer) {
//		nutzerManager.addNutzer(nutzer);
//		return new ModelAndView("redirect:/homepage");
//	}

	@GetMapping("/neuer_nutzer")
	public String addNutzer(Model model) {
        model.addAttribute("nutzer", new Nutzer());
        return "neuer_nutzer";
    }

}
