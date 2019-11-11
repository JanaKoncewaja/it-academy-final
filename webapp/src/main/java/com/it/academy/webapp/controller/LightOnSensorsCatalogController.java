package com.it.academy.webapp.controller;


import com.it.academy.domain.sensor.LightOnSensor;
import com.it.academy.domain.sensor.Sensor;
import com.it.academy.domain.sensor.TemperatureSensor;
import com.it.academy.service.SensorCatalogService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LightOnSensorsCatalogController {

    @Autowired
    SensorCatalogService sensorCatalogService;

    @RequestMapping(value = "catalogOfLightOnSensorsPage",method = RequestMethod.GET)
    public String showLightOnSensorsCatalog(Model model){
        List<LightOnSensor> lightOnSensors = sensorCatalogService.getAllLightOnSensors();
        model.addAttribute("lightOnSensors", lightOnSensors);
        return "catalogOfLightOnSensorsPage";
    }

    @RequestMapping(value = "catalogOfLightOnSensorsPage/sortedLightOnSensors")
    public String showSortedSensors(Model model){
        List<LightOnSensor> sortedLightOnSensors = sensorCatalogService.getSortedSensors();
        model.addAttribute("sortedLightOnSensors",sortedLightOnSensors);
        return "sortedLightOnSensors";
    }





}
