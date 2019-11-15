package com.it.academy.service.user;

import com.it.academy.data.dao.UserDao;
import com.it.academy.data.entity.UserEntity;
import com.it.academy.domain.user.AppRole;
import com.it.academy.domain.user.RoleName;
import com.it.academy.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserDao dao;

    @Autowired
    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public User getUserByName(String userName) {
        final UserEntity userEntity = dao.getUserByName(userName);
        return fromEntity(userEntity);
    }

    private User fromEntity(UserEntity entity) {
        final AppRole role = new AppRole(entity.getRole().getId(), entity.getRole().getRoleName());
        return new User(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getEmail(), role);
    }



}
