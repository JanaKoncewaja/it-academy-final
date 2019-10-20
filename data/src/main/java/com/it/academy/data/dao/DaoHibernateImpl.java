package com.it.academy.data.dao;

import com.it.academy.config.HibernateUtil;
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
    public <T>T get(Class<T> t,Long id) {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            return (T)session.get(t, id);
    }


    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(T t) {

    }

//
//    @Override
//    public MarkerInt get(Long id) {
//        Transaction tr=null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
// try {
//    tr =session.beginTransaction();
//    session.get(MarkerInt.class.getName(),id);
//    tr.commit();
//    session.close();
// }catch (HibernateException e){
//     logger.log(Level.INFO, e.getMessage());
// }
//
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//
//    @Override
//    public void update(MarkerInt markerInt) {
//
//    }
}
