package com.it.academy.data.dao;

import com.it.academy.data.entity.DeviceEntity;
import com.it.academy.data.entity.LightOnSensorEntity;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class DaoHibernateImplTest {

    private DeviceEntity deviceEntity;
    private LightOnSensorEntity lightOnSensorEntity;

    @Test
    public void save() {
        final Dao<DeviceEntity> deviceDao = new DaoHibernateImpl<>();
        final Long deviceId = deviceDao.save(new DeviceEntity("ItI","iiiuhY7","kitchen"));
        assertNotNull(deviceId);

        final DeviceEntity device = deviceDao.get(DeviceEntity.class, deviceId);
        assertNotNull(device);
        assertEquals(deviceId, device.getId());

        final Dao<LightOnSensorEntity> sensorDao = new DaoHibernateImpl<>();
        final Long sensorId = sensorDao.save(new LightOnSensorEntity("light-on-sensor1", device, false));
        assertNotNull(sensorId);

        final LightOnSensorEntity sensor = sensorDao.get(LightOnSensorEntity.class, sensorId);
        assertNotNull(sensor);
        assertEquals(sensorId, sensor.getId());

        final DeviceEntity sensorDevice = sensor.getDevice();
        assertNotNull(sensorDevice);
        assertEquals(device.getId(), sensorDevice.getId());
    }


    @Test
    public void get() {
        final Long deviceId = new DaoHibernateImpl<>().save(new DeviceEntity("ItI","iiiuhY7123","kitchen"));
        assertNotNull(deviceId);

        final DeviceEntity expected = new DaoHibernateImpl<DeviceEntity>().get(DeviceEntity.class, deviceId);
        assertNotNull(expected);
        assertEquals("ItI", expected.getName());
        assertEquals("iiiuhY7123", expected.getIp());
        assertEquals("kitchen", expected.getLocation());
    }

//    @Test
//    public void delete() {
//        DeviceEntity existing = createTestDevice();
//        new DaoHibernateImpl<>().save(existing);
//        new DaoHibernateImpl<>().delete(existing);
//        assertNull(new DaoHibernateImpl<>().get(DeviceEntity.class, existing.getId()));
//    }

}