package com.it.academy.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            throw new IllegalStateException("Initial SessionFactory creation failed.", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
