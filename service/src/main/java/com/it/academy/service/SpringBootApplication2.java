package com.it.academy.service;

import com.it.academy.data.dao.DaoHibernateImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


import javax.persistence.EntityManagerFactory;

@SpringBootApplication
@ComponentScan(basePackages = "it.")
public class SpringBootApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication2.class,args);

}
@Bean
public DaoHibernateImpl daoHibernate(){
        return new DaoHibernateImpl();
}}

