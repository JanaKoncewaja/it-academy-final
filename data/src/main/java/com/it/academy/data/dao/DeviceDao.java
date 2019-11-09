package com.it.academy.data.dao;

import com.it.academy.data.entity.DeviceEntity;

import java.util.List;

public class DeviceDao extends DaoHibernateImpl<DeviceEntity> {

    private final Dao<DeviceEntity> dao =new DaoHibernateImpl<>();;

    public List<DeviceEntity> getAll() {

        return dao.getAll("from DeviceEntity", DeviceEntity.class);
    }
}
