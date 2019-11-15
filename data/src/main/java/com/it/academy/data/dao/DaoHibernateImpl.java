package com.it.academy.data.dao;

import com.it.academy.config.HibernateUtil;
import com.it.academy.data.entity.DeviceEntity;
import com.it.academy.data.entity.LightOnSensorEntity;
import com.it.academy.data.entity.MarkerInt;
import org.hibernate.*;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoHibernateImpl<T extends MarkerInt> implements Dao<T> {

    private static final Logger logger = Logger.getLogger(DaoHibernateImpl.class.getName());

    private Session session;

    @Override
    public Long save(T t) {
        Transaction tr = null;
        Serializable id = null;
        session = HibernateUtil.getSessionFactory().openSession();
        if (t != null) {
            try {
                tr = session.beginTransaction();
                id = session.save(t);
                tr.commit();
                session.close();
            } catch (HibernateException e) {
                logger.log(Level.INFO, e.getMessage());
                if (tr != null) {
                    tr.rollback();
                    throw e;
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return (Long) id;
    }

    @Override
    public T get(Class<T> clazz,Long id) {
        Transaction tr = null;
        session = HibernateUtil.getSessionFactory().openSession();
        T obj=null;
        try {
            tr = session.beginTransaction();
           obj =session.get(clazz, id);
            tr.commit();
            session.close();
        } catch (HibernateException e) {
            logger.log(Level.INFO, e.getMessage());
            if (tr != null) {
                tr.rollback();
                throw e;
            }}
        return obj;
    }

    @Override
    public T get(String sql, Class<T> clazz) {
        Transaction tr = null;
        session = HibernateUtil.getSessionFactory().openSession();
        T obj=null;
        try {
            tr = session.beginTransaction();
            obj = session.createQuery(sql, clazz).getSingleResult();
            tr.commit();
            session.close();
        } catch (HibernateException e) {
            logger.log(Level.INFO, e.getMessage());
            if (tr != null) {
                tr.rollback();
                throw e;
            }}
        return obj;
    }

    @Override
    public void delete(T t) {
        Transaction tr = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Object obj=null;
        try {
            tr = session.beginTransaction();
            session.delete(t);
            tr.commit();
            session.close();
        } catch (HibernateException e) {
            logger.log(Level.INFO, e.getMessage());
            if (tr != null) {
                tr.rollback();
                throw e;
            }
        }
    }

    @Override
    public void update(T t) {
        Transaction tr = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Object obj=null;
        try {
            tr = session.beginTransaction();
            session.update(t);
            tr.commit();
            session.close();
        } catch (HibernateException e) {
            logger.log(Level.INFO, e.getMessage());
            if (tr != null) {
                tr.rollback();
                throw e;
             
            }
        }

    }

    @Override
    public List<T> getAll(String sql, Class<T> clazz) {
        Transaction tr = null;
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> list =null;
        try {
            tr = session.beginTransaction();
            list = session.createQuery(sql, clazz).setMaxResults(10).list();
            tr.commit();
            session.close();
        } catch (HibernateException e) {
            logger.log(Level.INFO, e.getMessage());
            if (tr != null) {
                tr.rollback();
                throw e;
            }}
        return list;
    }
}


