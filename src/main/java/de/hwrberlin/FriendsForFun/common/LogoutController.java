package de.hwrberlin.FriendsForFun.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping({"/logout.html"})
    public String logout(Model model){
        return "logout";
    }
	
}
