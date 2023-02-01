package com.redolf.config;

import com.redolf.model.Course;
import com.redolf.model.Parent;
import com.redolf.model.Student;

import java.util.Properties;
import java.util.Set;

import jakarta.persistence.Entity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.reflections.Reflections;

public class HibernateUtils {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate?useSSL=false");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "0552588647");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                

                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "hibernate.formate_sql");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create");

                configuration.setProperties(settings);

                Reflections classes = new Reflections("com.redolf.model");
                Set<Class<?>> model = classes.getTypesAnnotatedWith(Entity.class);
                for (Class<?> clazz : model) {
                    configuration.addAnnotatedClass(clazz);
                }
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
