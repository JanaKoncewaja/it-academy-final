package com.it.academy.service;

import com.it.academy.domain.sensor.LightOnSensor;
import com.it.academy.domain.sensor.TemperatureSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorCatalogService {

    LightOnSensorService lightOnSensorService;
    TemperatureSensorService temperatureSensorService;

    @Autowired
    public SensorCatalogService(LightOnSensorService lightOnSensorService, TemperatureSensorService temperatureSensorService) {
        this.lightOnSensorService = lightOnSensorService;
        this.temperatureSensorService = temperatureSensorService;
    }


    public List<LightOnSensor> getAllLightOnSensors(){
        return lightOnSensorService.getALl();
    }

    public List<TemperatureSensor> getAllTemperatureSensors(){
        return temperatureSensorService.getAll();
    }

    public List<LightOnSensor> getSortedLightOnSensors() { return lightOnSensorService.getSortedLightOnSensorsSensors();
    }

    public List<TemperatureSensor> getSortedTemperatureSensors() { return temperatureSensorService.getSortedTemperatureSensors();
    }

    public List<TemperatureSensor> getSortedByValueTempSens() { return temperatureSensorService.getSortedByValueTempSens();
    }
}
