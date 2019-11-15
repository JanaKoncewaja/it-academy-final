package com.it.academy.webapp.controller;

import com.it.academy.data.entity.LightOnSensorEntity;
import com.it.academy.service.LightOnSensorService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addLightOnSensor")
public class AddLightOnSensorController {

    @Autowired
    LightOnSensorService lightOnSensorService;

    @GetMapping
    public String showAddPage(){
        return "addLightOnSensor";
    }

    @PostMapping
    public String addLightOn(@ModelAttribute LightOnSensorEntity lightOnSensorEntity){
        lightOnSensorService.save(lightOnSensorEntity);
        return "redirect:/home";

    }

}
