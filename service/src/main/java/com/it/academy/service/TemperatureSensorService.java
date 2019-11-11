package com.it.academy.service;


import com.it.academy.data.dao.TemperatureSensoreDao;
import com.it.academy.data.entity.TemperatureSensorEntity;
import com.it.academy.domain.sensor.TemperatureSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemperatureSensorService {

    private TemperatureSensoreDao dao;

    @Autowired
    public TemperatureSensorService(TemperatureSensoreDao temperatureSensoreDao) {
        this.dao = temperatureSensoreDao;
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
}
