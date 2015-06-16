package com;

import com.Service.interfaces.JavaContactService;
import com.model.Contact;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by volodymyr on 15/06/15.
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ContactService javaContactService = context.getBean(JavaContactService.class);
        ContactDaoImpl contactDao = context.getBean(ContactDaoImpl.class);
        Contact contact = context.getBean(Contact.class);

        System.out.println(javaContactService.toString());
        System.out.println("___________________________________________________");
    }
}
