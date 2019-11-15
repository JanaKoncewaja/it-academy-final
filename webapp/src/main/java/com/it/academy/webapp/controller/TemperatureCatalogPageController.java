package com.it.academy.webapp.controller;

import com.it.academy.domain.sensor.TemperatureSensor;
import com.it.academy.service.DeviceService;
import com.it.academy.service.SensorCatalogService;
import com.it.academy.webapp.model.TemperatureCatalogPageItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TemperatureCatalogPageController {

    @Autowired
    SensorCatalogService sensorCatalogService;
    @Autowired
    DeviceService deviceService;

    @RequestMapping(value = "catalogOfTemperatureSensorsPage",method = RequestMethod.GET)
    public String showTemperatureCatalog(Model model){
        List<TemperatureSensor> temperatureSensors  = sensorCatalogService.getAllTemperatureSensors();
        model.addAttribute("temperatureSensors",convertToPageItems(temperatureSensors));
        return "catalogOfTemperatureSensorsPage";
    }

    @RequestMapping(value = "catalogOfTemperatureSensorsPage/sortedTemperatureSensors")
    public String showSortedSensors(Model model){
        List<TemperatureSensor> temperatureSensors = sensorCatalogService.getSortedTemperatureSensors();
        model.addAttribute("temperatureSensors",convertToPageItems(temperatureSensors));
        return "catalogOfTemperatureSensorsPage";
    }

    @RequestMapping(value = "catalogOfTemperatureSensorsPage/sortedByValueTemperatureSensors")
        public String showSortedByValueTemperatureSensors(Model model){
        List<TemperatureSensor> temperatureSensors =sensorCatalogService.getSortedByValueTempSens();
        model.addAttribute("temperatureSensors",convertToPageItems(temperatureSensors));
        return "catalogOfTemperatureSensorsPage";
    }

    private List<TemperatureCatalogPageItem> convertToPageItems(List<TemperatureSensor> sensors) {
        return sensors.stream()
                .map(sensor -> {
                    Long deviceId = sensorCatalogService.getDeviceIdForTemperatureSensor(sensor.getId());
                    String deviceName = deviceService.getById(deviceId).getName();
                    return new TemperatureCatalogPageItem(sensor, deviceName);
                })
                .collect(Collectors.toList());
    }
}
