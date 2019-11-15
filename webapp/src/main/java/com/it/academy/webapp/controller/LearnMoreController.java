package com.it.academy.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
public class LearnMoreController {
    Logger log = Logger.getLogger("LearnMoreController");

    @RequestMapping(value = "/learnMore", method = RequestMethod.GET)
    public String showTheLearnMorePage(){
        log.info("Showing the learnMorePage");

        return "learnMore";
  }
}
