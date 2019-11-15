package com.it.academy.webapp.controller;

import com.it.academy.data.entity.LightOnSensorEntity;
import com.it.academy.data.entity.TemperatureSensorEntity;
import com.it.academy.service.TemperatureSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addTemperatureSensor")
public class AddTemperatureSensorController {

    @Autowired
    TemperatureSensorService temperatureSensorService;

    @GetMapping
    public String showAddPage(){
        return "addTemperatureSensor";
    }

    @PostMapping
    public String addLightOn(@ModelAttribute TemperatureSensorEntity temperatureSensorEntity){
        temperatureSensorService.save(temperatureSensorEntity);
        return "redirect:/home";

    }

}
