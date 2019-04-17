package com.opensource.products.phonebook.server.config;

import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("file:/opt/phonebook/phonebook-ws.properties")
@EnableTransactionManagement
@ComponentScans(value =
{ @ComponentScan("com.opensource.products.phonebook.server") })
public class DatabaseConfig
{
    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean getSessionFactory()
    {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        Properties props = new Properties();

        // Setting JDBC properties
        // props.put(DRIVER, env.getProperty("hibernate.connection.driver.class"));
        // props.put(URL, env.getProperty("hibernate.connection.url"));
        // props.put(USER, env.getProperty("hibernate.connection.username"));
        // props.put(PASS, env.getProperty("hibernate.connection.password"));
        props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));

        // Setting Hibernate properties
        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        // props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));

        // Setting C3P0 properties
        props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.minPoolSize"));
        props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.maxPoolSize"));
        props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
        props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
        props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.maxStatements"));

        factoryBean.setHibernateProperties(props);
        factoryBean.setPackagesToScan("com.opensource.products.phonebook.server.domain");
        factoryBean.setDataSource(getDataSource());

        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager()
    {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public DataSource getDataSource()
    {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("hibernate.connection.driver.class"));
        dataSource.setUrl(env.getProperty("hibernate.connection.url"));
        dataSource.setUsername(env.getProperty("hibernate.connection.username"));
        dataSource.setPassword(env.getProperty("hibernate.connection.password"));
        return dataSource;
    }
}
