package com.it.academy.data.dao;

import com.it.academy.data.entity.DeviceEntity;
import com.it.academy.data.entity.LightOnSensorEntity;
import org.hibernate.Session;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DaoHibernateImplTest {
    Session session;
    private DeviceEntity deviceEntity;
    private LightOnSensorEntity lightOnSensorEntity;
    public DeviceEntity createTestDevice(){
         deviceEntity = new DeviceEntity("ItI","iiiuhY7","kitchen");
        return deviceEntity;
    }

    public LightOnSensorEntity createTestLightSensor(){
        List<DeviceEntity> deviceEntities = new ArrayList<>();
        deviceEntities.add(createTestDevice());
        lightOnSensorEntity=new LightOnSensorEntity("sensor1", deviceEntities,true);
        return lightOnSensorEntity;
    }

    @Test
    public void save() {
        new DaoHibernateImpl<>().save(createTestDevice());
        new DaoHibernateImpl<>().save(createTestLightSensor());
        }


    @Test
    public void get() {
        DeviceEntity existing = createTestDevice();
        new DaoHibernateImpl<>().save(existing);
        DeviceEntity expected = (DeviceEntity) new DaoHibernateImpl<>().get(DeviceEntity.class,(long)1);
        assertEquals(expected, existing);
    }

//    @Test
//    public void delete() {
//        DeviceEntity existing = createTestDevice();
//        new DaoHibernateImpl<>().save(existing);
//        new DaoHibernateImpl<>().delete(existing);
//        assertNull(new DaoHibernateImpl<>().get(DeviceEntity.class, existing.getId()));
//    }

}