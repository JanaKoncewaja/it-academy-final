package com.it.academy.service;

import com.it.academy.data.dao.DaoHibernateImpl;
import com.it.academy.data.dao.DeviceDao;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class DeviceServiceTest {


    @org.junit.Test
    public void getAll() {
        final DeviceDao deviceDao = new DeviceDao();
        final DeviceService deviceService=new DeviceService(deviceDao);
        assertNotNull(deviceService.getAll());
    }


}