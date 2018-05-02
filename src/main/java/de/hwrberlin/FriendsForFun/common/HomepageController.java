package de.hwrberlin.FriendsForFun.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {

    @RequestMapping({"/homepage.html "})
    public String index(Model model){
        return "homepage";
    }

}