package com.it.academy.service;

import com.it.academy.data.dao.LightOnSensorDao;
import com.it.academy.data.entity.LightOnSensorEntity;
import com.it.academy.domain.Device;
import com.it.academy.domain.sensor.LightOnSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Qualifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;

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

    public List<LightOnSensor> getALl(){
       return dao.getAll().stream().map(this::fromEntity).collect(Collectors.toList());
    }

    public List<LightOnSensor> getSortedLightOnSensorsSensors() {
         return dao.getAll().stream().map(this::fromEntity).sorted(Comparator.comparing(LightOnSensor::getName)).collect(Collectors.toList());

    }

    public List<LightOnSensor> searchProduct(String str) {
            if (str.isEmpty() || str == null) {
                getALl();
            }
            return dao.getAll().stream()
                    .filter(entity -> entity.getName()
                            .equals(str) || entity.getValue()
                            .equals(str) || entity.getDevice()
                            .equals(str)).map(this::fromEntity).collect(Collectors.toList());
        }

    public Long getDeviceId(Long sensorId) {
        return dao.get(LightOnSensorEntity.class, sensorId).getDevice().getId();
    }
}

