package com.it.academy.data.dao;

import com.it.academy.config.HibernateUtil;
import com.it.academy.data.entity.LightOnSensorEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.logging.Level;

public class LightOnSensorDao extends DaoHibernateImpl<LightOnSensorEntity> implements SensorDao<LightOnSensorEntity> {

private final Dao<LightOnSensorEntity> dao = new DaoHibernateImpl<>();

    public List<LightOnSensorEntity> getAll() {

        return dao.getAll("from LightOnSensorEntity", LightOnSensorEntity.class);
    }

    @Override
    public LightOnSensorEntity findByDeviceId(Long deviceId) {
        return get("from LightOnSensorEntity where deviceId = " + deviceId, LightOnSensorEntity.class);
    }
}
