package com.it.academy.service;


import com.it.academy.data.dao.TemperatureSensoreDao;
import com.it.academy.data.entity.TemperatureSensorEntity;
import com.it.academy.domain.sensor.LightOnSensor;
import com.it.academy.domain.sensor.TemperatureSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemperatureSensorService {

    private TemperatureSensoreDao dao;

    @Autowired
    public TemperatureSensorService(TemperatureSensoreDao dao) {
        this.dao = dao;
    }

    public TemperatureSensor getByDeviceId(Long deviceId) {
        final TemperatureSensorEntity entity = dao.findByDeviceId(deviceId);
        return fromEntity(entity);
    }

    private TemperatureSensor fromEntity(TemperatureSensorEntity entity) {
        return new TemperatureSensor(entity.getId(), entity.getName(), entity.getValue());
    }

    public List<TemperatureSensor> getAll() {
        return dao.getAll().stream().map(this::fromEntity).collect(Collectors.toList());
    }

    public List<TemperatureSensor> getSortedTemperatureSensors() {
        return dao.getAll().stream().map(this::fromEntity).sorted(Comparator.comparing(TemperatureSensor::getName)).collect(Collectors.toList());

    }

    public List<TemperatureSensor> getSortedByValueTempSens() {
        return dao.getAll().stream().map(this::fromEntity).sorted(Comparator.comparing(TemperatureSensor::getValue)).collect(Collectors.toList());
    }

    public List<TemperatureSensor> searchProduct(String str) {
        if (str.isEmpty() || str == null) {
            getAll();
        }
        return dao.getAll().stream()
                .filter(entity -> entity.getName()
                        .equals(str) || entity.getValue()
                        .equals(str) || entity.getDevice()
                        .equals(str)).map(this::fromEntity).collect(Collectors.toList());
    }
    }

