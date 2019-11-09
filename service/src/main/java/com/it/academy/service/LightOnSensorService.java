package com.it.academy.service;

import com.it.academy.data.dao.LightOnSensorDao;
import com.it.academy.data.entity.LightOnSensorEntity;
import com.it.academy.domain.sensor.LightOnSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Qualifier;

@Service
public class LightOnSensorService {

    private LightOnSensorDao dao;

    @Autowired
    public LightOnSensorService(LightOnSensorDao dao) {
        this.dao = dao;
    }

    public LightOnSensor getByDeviceId(Long deviceId) {
        final LightOnSensorEntity entity = dao.findByDeviceId(deviceId);
        return fromEntity(entity);
    }

    private LightOnSensor fromEntity(LightOnSensorEntity entity) {
        return new LightOnSensor(entity.getId(), entity.getName(), entity.getValue());
    }
}
