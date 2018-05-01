package de.hwrberlin.FriendsForFun.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewUserController {

	 @GetMapping("/neuer_nutzer.html")
	    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", name);
	        return "neuer_nutzer";
	    }
	
}
