package com.it.academy.service.catalog;


import com.it.academy.domain.Device;
import com.it.academy.domain.sensor.LightOnSensor;
import com.it.academy.domain.sensor.TemperatureSensor;
import com.it.academy.service.DeviceService;
import com.it.academy.service.LightOnSensorService;
import com.it.academy.service.TemperatureSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeviceCatalogService {

    DeviceService deviceService;
    LightOnSensorService lightOnSensorService;
    TemperatureSensorService temperatureSensorService;

    @Autowired
    public DeviceCatalogService(DeviceService deviceService, LightOnSensorService lightOnSensorService, TemperatureSensorService temperatureSensorService) {
        this.deviceService = deviceService;
        this.lightOnSensorService = lightOnSensorService;
        this.temperatureSensorService=temperatureSensorService;
    }

    public Device getDeviceById(Long id){
        Device device = deviceService.getById(id);
        LightOnSensor lightOnSensor = lightOnSensorService.getByDeviceId(device.getId());
        TemperatureSensor temperatureSensor =temperatureSensorService.getByDeviceId(device.getId());
        device.addSensor(temperatureSensor);
        device.addSensor(lightOnSensor);
        return device;
    }

    public List<Device> getAllDevices(){
        return deviceService.getAll();
    }

    public List<Device> searchProduct(String str){
return deviceService.getSearchResult(str);
    }

    public List<Device> gerSortedDevices() {
        return deviceService.getSortedDevices();
    }
}
