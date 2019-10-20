package com.it.academy.data.dao;

import com.it.academy.data.entity.MarkerInt;

import java.io.Serializable;

public  interface Dao <T extends MarkerInt>{

    void save(T t);
    <T>T get(Class<T> t,Long id);
    void delete(Long id);
    void update(T t);
}


