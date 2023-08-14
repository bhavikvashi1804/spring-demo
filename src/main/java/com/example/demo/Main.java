package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        String applicationName = applicationContext.getBean("applicationName", String.class);
        System.out.println("Application Name: "+ applicationName);
    }
}