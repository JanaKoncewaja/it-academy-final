package com.it.academy.data.dao;

import com.it.academy.data.entity.DeviceEntity;
import com.it.academy.data.entity.LightOnSensorEntity;
import com.it.academy.data.entity.TemperatureSensorEntity;
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
    private TemperatureSensorEntity temperatureSensorEntity;

    @Test
    public void save() {
        final Dao<DeviceEntity> deviceDao = new DaoHibernateImpl<>();
        final Long deviceId = deviceDao.save(new DeviceEntity("ItI","iiiuhY7","kitchen"));
        final Long deviceId2 =deviceDao.save(new DeviceEntity("Mko2","oow7tt","bathroom"));
        assertNotNull(deviceId);
        assertNotNull(deviceId2);

        final DeviceEntity device = deviceDao.get(DeviceEntity.class, deviceId);
        final DeviceEntity device2=deviceDao.get(DeviceEntity.class,deviceId2);
        assertNotNull(device);
        assertNotNull(device2);
        assertEquals(deviceId, device.getId());
        assertEquals(deviceId2,device2.getId());

        final Dao<LightOnSensorEntity> sensorDao = new DaoHibernateImpl<>();
        final Dao<TemperatureSensorEntity> tempDao = new DaoHibernateImpl<>();
        final Long sensorId = sensorDao.save(new LightOnSensorEntity("light-on-sensor1", device, false));
       final Long sensorId2= sensorDao.save(new LightOnSensorEntity("Isensor2",device2,true));
       final Long tempSensId = tempDao.save(new TemperatureSensorEntity("tempSens1", device, 33.6));
        assertNotNull(sensorId);
        assertNotNull(sensorId2);
        assertNotNull(tempSensId);

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