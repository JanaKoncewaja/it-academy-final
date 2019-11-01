package com.it.academy.data.dao;

import com.it.academy.data.entity.MarkerInt;

import java.io.Serializable;
import java.util.List;

public  interface Dao <T extends MarkerInt>{

    void save(T t);
   Object get(Class clazz,Long id);
    void delete(T t);
    void update(T t);
}


