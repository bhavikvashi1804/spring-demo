package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ImportResource({"classpath:hibernate5Configuration.xml"})
@Primary
public class HibernateXMLConf {

    // URL for ref: https://www.baeldung.com/spring-oracle-connection-pooling
    // URL for ref: https://www.baeldung.com/hibernate-5-spring

}