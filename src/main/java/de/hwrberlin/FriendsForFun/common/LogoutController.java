package de.hwrberlin.FriendsForFun.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class LogoutController {

	@RequestMapping({"/logout.html"})
    public String logout(Model model){
        return "logout";
    }
	
}
