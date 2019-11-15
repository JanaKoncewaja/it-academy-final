package com.it.academy.webapp.controller;


import com.it.academy.domain.sensor.LightOnSensor;
import com.it.academy.domain.sensor.TemperatureSensor;
import com.it.academy.service.DeviceService;
import com.it.academy.service.SensorCatalogService;
import com.it.academy.webapp.model.LightOnCatalogPageItem;
import com.it.academy.webapp.model.TemperatureCatalogPageItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LightOnSensorsCatalogController {

    @Autowired
    SensorCatalogService sensorCatalogService;
    @Autowired
    DeviceService deviceService;

    @RequestMapping(value = "catalogOfLightOnSensorsPage",method = RequestMethod.GET)
    public String showLightOnSensorsCatalog(Model model){
        List<LightOnSensor> lightOnSensors = sensorCatalogService.getAllLightOnSensors();
        model.addAttribute("lightOnSensors", convertToPageItems(lightOnSensors));
        return "catalogOfLightOnSensorsPage";
    }

    @RequestMapping(value = "catalogOfLightOnSensorsPage/sortedLightOnSensors")
    public String showSortedSensors(Model model){
        List<LightOnSensor> lightOnSensors = sensorCatalogService.getSortedLightOnSensors();
        model.addAttribute("lightOnSensors", convertToPageItems(lightOnSensors));
        return "catalogOfLightOnSensorsPage";
    }


    private List<LightOnCatalogPageItem> convertToPageItems(List<LightOnSensor> sensors) {
        return sensors.stream()
                .map(sensor -> {
                    Long deviceId = sensorCatalogService.getDeviceIdForLightOnSensor(sensor.getId());
                    String deviceName = deviceService.getById(deviceId).getName();
                    return new LightOnCatalogPageItem(sensor, deviceName);
                })
                .collect(Collectors.toList());
    }


}
