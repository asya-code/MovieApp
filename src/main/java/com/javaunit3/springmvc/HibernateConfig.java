package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateConfig {
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(MovieEntity.class)
            .buildSessionFactory();
    return factory;
}
