package com.it.academy.data.dao;

import com.it.academy.data.entity.MarkerInt;
import org.hibernate.Criteria;

import java.io.Serializable;
import java.util.List;

public interface Dao<T extends MarkerInt> {

    Long save(T t);
    T get(Class<T> clazz, Long id);
    T get(String sql, Class<T> clazz);
    void delete(T t);
    void update(T t);

    List<T> getAll(String sql,Class<T> clazz);
}


