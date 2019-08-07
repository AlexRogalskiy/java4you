package com.sensiblemetrics.api.alpenidos.core.service_layer.utils;

import com.sensiblemetrics.api.alpenidos.core.command2.factory.Wizard;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sensiblemetrics.api.alpenidos.core.service_layer.spell.Spell;
import com.sensiblemetrics.api.alpenidos.core.service_layer.spellbook.Spellbook;

/**
 * Produces the Hibernate {@link SessionFactory}.
 */
@Slf4j
@UtilityClass
public class HibernateUtil {

    /**
     * The cached session factory
     */
    private static volatile SessionFactory sessionFactory;

    /**
     * Create the current session factory instance, create a new one when there is none yet.
     *
     * @return The session factory
     */
    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                sessionFactory =
                    new Configuration()
                        .addAnnotatedClass(Wizard.class)
                        .addAnnotatedClass(Spellbook.class)
                        .addAnnotatedClass(Spell.class)
                        .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                        .setProperty("hibernate.connection.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1")
                        .setProperty("hibernate.current_session_context_class", "thread")
                        .setProperty("hibernate.show_sql", "false")
                        .setProperty("hibernate.hbm2ddl.auto", "create-drop").buildSessionFactory();
            } catch (Throwable ex) {
                log.error("Initial SessionFactory creation failed.", ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    /**
     * Drop the current connection, resulting in a create-drop clean database next time. This is
     * mainly used for JUnit testing since one test should not influence the other
     */
    public static void dropSession() {
        getSessionFactory().close();
        sessionFactory = null;
    }
}
