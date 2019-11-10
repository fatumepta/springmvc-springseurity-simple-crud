package jm.fatumepta.springmvc.app.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Objects;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@PropertySource("classpath:persistence-postgres.properties")
public class HibernateConfig {
    private Environment env;

    @Autowired
    public HibernateConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new HibernateTransactionManager(sessionFactory().getObject());
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("jm.fatumepta.springmvc.app.model");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(env.getProperty("jdbc.driver"));
            dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
            dataSource.setUser(env.getProperty("jdbc.user"));
            dataSource.setPassword(env.getProperty("jdbc.password"));

            dataSource.setInitialPoolSize(
                    Integer.parseInt(Objects.requireNonNull(env.getProperty("connection.pool.initialPoolSize"))));
            dataSource.setMinPoolSize(
                    Integer.parseInt(Objects.requireNonNull(env.getProperty("connection.pool.minPoolSize"))));
            dataSource.setMaxPoolSize(
                    Integer.parseInt(Objects.requireNonNull(env.getProperty("connection.pool.maxPoolSize"))));
            dataSource.setMaxIdleTime(
                    Integer.parseInt(Objects.requireNonNull(env.getProperty("connection.pool.maxIdleTime"))));
        } catch (PropertyVetoException exc) {
            exc.printStackTrace();
        }

        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "validate");

        return hibernateProperties;
    }

}
