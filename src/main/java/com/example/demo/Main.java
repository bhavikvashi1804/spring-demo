package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String activateProfile = environment.getProperty("spring.profiles.active");
        environment.setActiveProfiles(activateProfile);
        applicationContext.setConfigLocation("beans.xml");
        applicationContext.refresh();

        String applicationName = applicationContext.getBean("applicationName", String.class);
        System.out.println("Application Name: "+ applicationName);
    }
}