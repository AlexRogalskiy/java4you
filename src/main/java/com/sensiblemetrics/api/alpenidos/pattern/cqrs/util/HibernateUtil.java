//package com.sensiblemetrics.api.alpenidos.core.cqrs.util;
//
//import lombok.extern.slf4j.Slf4j;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//
///**
// * This class simply returns one instance of {@link SessionFactory} initialized when the application is started
// */
//@Slf4j
//public class HibernateUtil {
//    private static final SessionFactory SESSIONFACTORY = buildSessionFactory();
//
//    private static SessionFactory buildSessionFactory() {
//        // configures settings from hibernate.cfg.xml
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//        try {
//            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
//        } catch (Exception ex) {
//            StandardServiceRegistryBuilder.destroy(registry);
//            log.error("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return SESSIONFACTORY;
//    }
//}
