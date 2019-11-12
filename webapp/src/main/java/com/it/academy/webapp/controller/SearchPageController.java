package com.it.academy.webapp.controller;


import com.it.academy.domain.Device;
import com.it.academy.domain.sensor.LightOnSensor;
import com.it.academy.domain.sensor.TemperatureSensor;
import com.it.academy.service.LightOnSensorService;
import com.it.academy.service.TemperatureSensorService;
import com.it.academy.service.catalog.DeviceCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("search")
public class SearchPageController {

    private static Logger logger = Logger.getLogger("SearchPageController");

    @Autowired
    DeviceCatalogService deviceCatalogService;

    @Autowired
    LightOnSensorService lightOnSensorService;

    @Autowired
    TemperatureSensorService temperatureSensorService;

    @GetMapping
    public String showSearchPage(@RequestParam String str, Model model) {
        List<Device> devices = deviceCatalogService.searchProduct(str);
        List<LightOnSensor> lightOnSensors =lightOnSensorService.searchProduct(str);
        List<TemperatureSensor> temperatureSensors =temperatureSensorService.searchProduct(str);

        model.addAttribute("devices", devices);
        model.addAttribute("lightOnSensors",lightOnSensors);
        model.addAttribute("temperatureSensors",temperatureSensors);
        return "searchPage";
    }
}
