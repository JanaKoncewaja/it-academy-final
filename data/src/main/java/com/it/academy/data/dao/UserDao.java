package com.it.academy.data.dao;

import com.it.academy.data.entity.DeviceEntity;
import com.it.academy.data.entity.UserEntity;
import com.it.academy.domain.user.AppRole;
import com.it.academy.domain.user.RoleName;
import com.it.academy.domain.user.User;

public class UserDao extends DaoHibernateImpl<UserEntity> {

    public UserEntity getUserByName(String name) {
        return get(String.format("from UserEntity where username like '%s'", name), UserEntity.class);
    }

}
