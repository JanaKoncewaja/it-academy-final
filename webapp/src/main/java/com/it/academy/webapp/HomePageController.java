package com.it.academy.webapp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Controller
@RequestMapping("/home")
public class HomePageController {

    Logger log = Logger.getLogger("HomePageController");
    @RequestMapping (method = RequestMethod.GET)
    public String showTheHomePage(){

log.info("Showing the homepage");

return "home";
    }

}
