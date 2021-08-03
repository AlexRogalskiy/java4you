package com.sensiblemetrics.api.alpenidos.pattern.repository.config;

import com.sensiblemetrics.api.alpenidos.pattern.repository.RepositoryPatternLoader;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * This is the same example as in {@link RepositoryPatternLoader} but with annotations based
 * configuration for Spring.
 */
@Slf4j
@Configuration
@EnableJpaRepositories
public class DbConfiguration {

    /**
     * Creation of H2 db
     *
     * @return A new Instance of DataSource
     */
    @Bean
    @Primary
    //@ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(final DataSourceProperties dataSourceProperties) {
        return DataSourceBuilder
            .create()
            .url(dataSourceProperties.getUrl())
            .username(dataSourceProperties.getUsername())
            .password(dataSourceProperties.getPassword())
            .driverClassName(dataSourceProperties.getDriverClassName())
            .build();
    }

    /**
     * Factory to create a especific instance of Entity Manager
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource) {
        final LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource);
        entityManager.setPackagesToScan("com.sensiblemetrics.api.alpenidos.core.repository");
        entityManager.setPersistenceProvider(new HibernatePersistenceProvider());
        entityManager.setJpaProperties(this.jpaProperties());
        return entityManager;
    }

    /**
     * Properties for Jpa
     */
    private static Properties jpaProperties() {
        final Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        return properties;
    }

    /**
     * Get transaction manager
     */
    @Bean
    public JpaTransactionManager transactionManager(final LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        return transactionManager;
    }
}
