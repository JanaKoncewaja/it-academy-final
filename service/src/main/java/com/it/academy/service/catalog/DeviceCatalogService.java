package com.it.academy.service.catalog;

import com.it.academy.data.dao.DaoHibernateImpl;
import com.it.academy.data.entity.DeviceEntity;
import com.it.academy.domain.Device;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ReactiveTypeDescriptor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeviceCatalogService {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    DaoHibernateImpl daoHibernate;

    @Transactional
    public DeviceEntity getDeviceById(Long id){
  return (DeviceEntity) daoHibernate.get(DeviceEntity.class, id);
//        Device device = new Device(deviceEntity.getId(),deviceEntity.getName(),deviceEntity.getIp(),deviceEntity.getLocation());
//        return device;
    }

    @Transactional
  public List<DeviceEntity> getAllDevices(){
return sessionFactory.openSession()
        .createQuery(" from DeviceEntity", DeviceEntity.class)
        .list();
  }

}
