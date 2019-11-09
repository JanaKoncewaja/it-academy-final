package com.it.academy.service.catalog;

import com.it.academy.data.dao.Dao;
import com.it.academy.data.dao.DeviceDao;
import com.it.academy.data.entity.DeviceEntity;
import com.it.academy.domain.Device;
import com.it.academy.domain.sensor.LightOnSensor;
import com.it.academy.service.DeviceService;
import com.it.academy.service.LightOnSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeviceCatalogService {

    DeviceService deviceService;
    LightOnSensorService lightOnSensorService;

    @Autowired
    public DeviceCatalogService(DeviceService deviceService, LightOnSensorService lightOnSensorService) {
        this.deviceService = deviceService;
        this.lightOnSensorService = lightOnSensorService;
    }

    public Device getDeviceById(Long id){
        Device device = deviceService.getById(id);
        LightOnSensor lightOnSensor = lightOnSensorService.getByDeviceId(device.getId());
        device.addSensor(lightOnSensor);
        return device;
    }

    public List<Device> getAllDevices(){
        return deviceService.getAll();
    }

    public List<Device> searchProduct(String str){
return deviceService.getSearchResult(str);
    }
}
