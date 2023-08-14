package com.example.demo.config;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration(value = "hibernateJavaConf")
@EnableTransactionManagement
public class HibernateJavaConf {

    @Value("${datasource.URL}")
    private String url;

    @Value("${datasource.user}")
    private String user;

    @Value("${datasource.password}")
    private String password;


    @Autowired
    ResourceLoader resourceLoader;


    @Bean(value = "javaConfigSessionFactory")
    public LocalSessionFactoryBean localSessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        localSessionFactoryBean.setMappingLocations(loadResources());
        return localSessionFactoryBean;
    }

    public Resource[] loadResources(){
        Resource[] resources = null;
        try{
            resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader)
                    .getResources("classpath*:/com/example/demo/model/**/*.hbm.xml");
        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        return  resources;
    }

    @Bean
    public DataSource dataSource(){
        OracleDataSource oracleDataSource  =  null;
        try{
            oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL(url);
            oracleDataSource.setUser(user);
            oracleDataSource.setPassword(password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return  oracleDataSource;
    }

    private  final Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.OracleDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto","validate");
        return  properties;
    }
}
