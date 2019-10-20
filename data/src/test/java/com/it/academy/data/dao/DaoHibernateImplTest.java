package com.it.academy.data.dao;

import com.it.academy.config.HibernateUtil;
import com.it.academy.data.entity.Device;
import com.it.academy.data.entity.LightOnSensorEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static org.junit.Assert.*;

public class DaoHibernateImplTest {
    private Device device;
    private LightOnSensorEntity lightOnSensorEntity;
    public Device createTestDevice(){
         device = new Device("ItI","iiiuhY7","kitchen");
        return device;
    }

    public LightOnSensorEntity createTestLightSensor(){
        List<Device> devices= new ArrayList<>();
        devices.add(createTestDevice());
        lightOnSensorEntity=new LightOnSensorEntity("sensor1",devices,true);
        return lightOnSensorEntity;
    }

    @Test
    public void save() {
        Session session;
        Transaction tr=null;
        session= HibernateUtil.getSessionFactory().openSession();
        try {
            tr=session.beginTransaction();
new DaoHibernateImpl<>().save(createTestDevice());
new DaoHibernateImpl<>().save(createTestLightSensor());
            tr.commit();
            session.close();
        } catch (HibernateException e) {
            if(tr!=null){
                tr.rollback();
                throw e;
            }
        }
    }

    @Test
    public void get() {

    }
}