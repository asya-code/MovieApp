package com.javaunit3.springmvc;

import com.javaunit3.springmvc.model.MovieEntity;
import com.javaunit3.springmvc.model.VoteEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;


public class HibernateConfig {
    @Bean
    public SessionFactory getFactory(){
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(MovieEntity.class)
            .addAnnotatedClass(VoteEntity.class)
            .buildSessionFactory();
    return factory;
    }
}
