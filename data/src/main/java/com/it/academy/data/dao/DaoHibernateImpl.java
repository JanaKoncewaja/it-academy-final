package com.it.academy.data.dao;

import com.it.academy.config.HibernateUtil;
import com.it.academy.data.entity.DeviceEntity;
import com.it.academy.data.entity.LightOnSensorEntity;
import com.it.academy.data.entity.MarkerInt;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoHibernateImpl<T extends MarkerInt> implements Dao<T> {

    private static final Logger logger = Logger.getLogger(DaoHibernateImpl.class.getName());

    private Session session;

    @Override
    public void save(T t) {
        Transaction tr = null;
        session = HibernateUtil.getSessionFactory().openSession();
        if (t != null) {
            try {
                tr = session.beginTransaction();
                session.save(t);
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
    }



    @Override
    public Object get(Class clazz,Long id) {
        Transaction tr = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Object obj=null;
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
}


