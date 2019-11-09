package com.it.academy.data.dao;

import com.it.academy.data.entity.AbstractSensorEntity;

public interface SensorDao<T extends AbstractSensorEntity> extends Dao<T> {

    T findByDeviceId(Long deviceId);
}
