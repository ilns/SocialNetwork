package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by volodymyr on 15/06/15.
 */
public class App {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    }
}
