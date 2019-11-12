package com.it.academy.data.dao;

import com.it.academy.data.entity.TemperatureSensorEntity;

import java.util.List;

public class TemperatureSensoreDao extends DaoHibernateImpl<TemperatureSensorEntity> implements SensorDao<TemperatureSensorEntity> {

    private final DaoHibernateImpl<TemperatureSensorEntity> dao=new DaoHibernateImpl<>();

    public List<TemperatureSensorEntity> getAll() {
        return dao.getAll("from TemperatureSensorEntity", TemperatureSensorEntity.class);
    }

    @Override
    public TemperatureSensorEntity findByDeviceId(Long deviceId) {
        return get("from TemperatureSensor where deviceId = "+deviceId, TemperatureSensorEntity.class);
    }
}
