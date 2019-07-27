//package com.sensiblemetrics.api.alpenidos.core.dao.config;
//
//import com.baeldung.daopattern.entities.User;
//import com.mysql.cj.jdbc.MysqlDataSource;
//import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
//import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.spi.PersistenceUnitInfo;
//import javax.sql.DataSource;
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class JpaEntityManagerFactory {
//    private final String DB_URL = "jdbc:mysql://databaseurl";
//    private final String DB_USER_NAME = "username";
//    private final String DB_PASSWORD = "password";
//
//    public EntityManager getEntityManager() {
//        return getEntityManagerFactory().createEntityManager();
//    }
//
//    protected EntityManagerFactory getEntityManagerFactory() {
//        PersistenceUnitInfo persistenceUnitInfo = getPersistenceUnitInfo(getClass().getSimpleName());
//        Map<String, Object> configuration = new HashMap<>();
//        return new EntityManagerFactoryBuilderImpl(new PersistenceUnitInfoDescriptor(persistenceUnitInfo), configuration)
//            .build();
//    }
//
//    protected PersistenceUnitInfoImpl getPersistenceUnitInfo(String name) {
//        return new PersistenceUnitInfoImpl(name, getEntityClassNames(), getProperties());
//    }
//
//    protected List<String> getEntityClassNames() {
//        return Arrays.asList(getEntities())
//            .stream()
//            .map(Class::getName)
//            .collect(Collectors.toList());
//    }
//
//    protected Properties getProperties() {
//        final Properties properties = new Properties();
//        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        properties.put("hibernate.id.new_generator_mappings", false);
//        properties.put("hibernate.connection.datasource", this.getMysqlDataSource());
//        return properties;
//    }
//
//    protected Class[] getEntities() {
//        return new Class[]{User.class};
//    }
//
//    protected DataSource getMysqlDataSource() {
//        final MysqlDataSource mysqlDataSource = new MysqlDataSource();
//        mysqlDataSource.setURL(DB_URL);
//        mysqlDataSource.setUser(DB_USER_NAME);
//        mysqlDataSource.setPassword(DB_PASSWORD);
//        return mysqlDataSource;
//    }
//}
