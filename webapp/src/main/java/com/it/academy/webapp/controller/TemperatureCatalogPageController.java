package com.it.academy.webapp.controller;

import com.it.academy.domain.sensor.TemperatureSensor;
import com.it.academy.service.SensorCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TemperatureCatalogPageController {

    @Autowired
    SensorCatalogService sensorCatalogService;

    @RequestMapping(value = "catalogOfTemperatureSensorsPage",method = RequestMethod.GET)
    public String showTemperatureCatalog(Model model){
        List<TemperatureSensor> temperatureSensors  = sensorCatalogService.getAllTemperatureSensors();
        model.addAttribute("temperatureSensors",temperatureSensors);
        return "catalogOfTemperatureSensorsPage";
    }

    @RequestMapping(value = "catalogOfTemperatureSensorsPage/sortedTemperatureSensors")
    public String showSortedSensors(Model model){
        List<TemperatureSensor> sortedTemperatureSensors = sensorCatalogService.getSortedTemperatureSensors();
        model.addAttribute("sortedTemperatureSensors",sortedTemperatureSensors);
        return "sortedTemperatureSensors";
    }

    @RequestMapping(value = "catalogOfTemperatureSensorsPage/sortedByValueTemperatureSensors")
        public String showSortedByValueTemperatureSensors(Model model){
        List<TemperatureSensor> sortedByValueTemperatureSensors =sensorCatalogService.getSortedByValueTempSens();
        model.addAttribute("sortedByValueTemperatureSensors",sortedByValueTemperatureSensors);
        return "sortedByValueTemperatureSensors";
    }
}
