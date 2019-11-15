package com.it.academy.data.dao;

import com.it.academy.data.entity.DeviceEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeviceDaoTest {

   private DaoHibernateImpl<DeviceEntity> daoHibernate;
   private DeviceDao deviceDao;

    @Before
    public void setUp() throws Exception {
       daoHibernate=new DaoHibernateImpl<>();
       deviceDao=new DeviceDao();
    }

    @Test
    public void getAll() {
        assertNotNull(deviceDao.getAll());

    }
}
