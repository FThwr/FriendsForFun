package de.hwrberlin.FriendsForFun.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class LoginController {

    @RequestMapping({"/index.html"})
    public String index(Model model){
        return "index";
    }

}