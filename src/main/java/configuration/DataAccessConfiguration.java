package configuration;

import org.h2.jdbcx.JdbcConnectionPool;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("project.repository")
@EnableTransactionManagement
@EnableJpaAuditing
@PropertySource("classpath:application.properties")
@ComponentScan("project")
public class DataAccessConfiguration {

    @Resource
    private Environment environment;

    @Value("${db.url}") String dbUrl;
    @Value("${db.username}") String username;
    @Value("${db.password}") String password;

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
//        dataSource.setUrl(environment.getRequiredProperty("db.url"));
//        dataSource.setUsername(environment.getRequiredProperty("db.username"));
//        dataSource.setPassword(environment.getRequiredProperty("db.password"));
//
//        return dataSource;
//    }

    // TEST MODE:
    @Bean
    public DataSource dataSource() {
        return JdbcConnectionPool.create(dbUrl, username, password);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setPackagesToScan(environment.getRequiredProperty("db.entitymanager.packages.to.scan"));

        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("db.hibernate.dialect", environment.getRequiredProperty("db.hibernate.dialect"));
        properties.put("db.hibernate.show_sql", environment.getRequiredProperty("db.hibernate.show_sql"));
        properties.put("db.hibernate.hbm2ddl.auto", environment.getRequiredProperty("db.hibernate.hbm2ddl.auto"));

        return properties;
    }
}
