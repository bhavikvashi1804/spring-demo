package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration(value = "hibernateJavaConf")
@EnableTransactionManagement
@PropertySources(
        value = {
                @PropertySource("classpath:application.properties"),
                @PropertySource("classpath:application-${spring.profiles.active}.properties")
        })
public class HibernateJavaConf {

    @Autowired
    ResourceLoader resourceLoader;
    @Value("${datasource.URL}")
    private String url;
    @Value("${datasource.user}")
    private String user;
    @Value("${datasource.password}")
    private String password;
    @Value("${datasource.dialect}")
    private String dialect;
    @Value("${datasource.driverclass}")
    private String driverClassName;
    @Value("${datasource.showSql}")
    private String showSql;
    @Value("${datasource.formatSql}")
    private String formatSql;
    @Value("${datasource.ddlAuto}")
    private String ddlAuto;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Bean(value = "javaConfigSessionFactory")
    public LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        localSessionFactoryBean.setMappingLocations(loadResources());
        // Way 1: Exact Class: specifying the exact classes to be mapped with DB
        // localSessionFactoryBean.setAnnotatedClasses(Person.class, Employee.class);
        // Way 2: Base Package: provide the base package to scan, base package & class which has @Entity will be mapped
        localSessionFactoryBean.setPackagesToScan("com.example.demo.model");
        // Way 3: Annotated Packages
        // localSessionFactoryBean.setAnnotatedPackages("com.example.demo.model.person");
        return localSessionFactoryBean;
    }

    public Resource[] loadResources() {
        Resource[] resources = null;
        try {
            resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath*:/com/example/demo/model/**/*.hbm.xml");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return resources;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        try {
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
            dataSource.setDriverClassName(driverClassName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dataSource;
    }

    private final Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.show_sql", showSql);
        properties.setProperty("hibernate.format_sql", formatSql);
        properties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
        return properties;
    }
}
