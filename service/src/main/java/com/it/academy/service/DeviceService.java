package com.it.academy.service;

import com.it.academy.data.dao.DeviceDao;
import com.it.academy.data.entity.DeviceEntity;
import com.it.academy.domain.Device;
import com.it.academy.domain.sensor.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceService {

    private DeviceDao dao;

    @Autowired
    public DeviceService(DeviceDao dao) {
        this.dao = dao;
    }


    public List<Device> getAll() {
        return dao.getAll().stream().map(this::fromEntity).collect(Collectors.toList());

    }

    public Device getById(Long id) {
        final DeviceEntity entity = dao.get(DeviceEntity.class, id);
        return fromEntity(entity);
    }

    public Device getById(Long id, List<Sensor> sensors) {
        final Device device = getById(id);
        sensors.forEach(device::addSensor);
        return device;
    }

    private Device fromEntity(DeviceEntity entity) {
        return new Device(entity.getId(), entity.getName(), entity.getIp(), entity.getLocation());
    }

    private DeviceEntity fromDevice(Device device){
        return new DeviceEntity(device.getId(),device.getName(),device.getIp(),device.getLocation());
    }


    public List<Device> getSearchResult(String str) {
        if (str.isEmpty() || str == null) {
            getAll();
        }
        return dao.getAll().stream()
                .filter(entity -> entity.getName()
                        .equals(str) || entity.getLocation()
                        .equals(str) || entity.getIp()
                        .equals(str)).map(this::fromEntity).collect(Collectors.toList());
    }

    public void save(DeviceEntity device){
        dao.save(device);
    }

    public List<Device> getSortedDevices() {
        return dao.getAll().stream().map(this::fromEntity).sorted(Comparator.comparing(Device::getName)).collect(Collectors.toList());

    }

}
