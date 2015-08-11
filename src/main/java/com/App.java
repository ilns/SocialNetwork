package com;

import com.Service.interfaces.JavaContactService;
import com.dao.Interfaces.ContactDao;
import com.dao.Interfaces.HobbyDao;
import com.model.Contact;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by volodymyr on 15/06/15.
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        JavaContactService javaContactService = context.getBean(JavaContactService.class);
        ContactDao contactDao = context.getBean(ContactDao.class);
        HobbyDao hobbyDao = context.getBean(HobbyDao.class);


        Contact a = new Contact("Vova","Zinchenko", new Date(1993,3,12));
        contactDao.addContact(a);


        //javaContactService.createContact("Vova","Zinchenko", new Date(1993,3,12));

//        Hobby h = new Hobby();
//        h.setTitle("title");
//        h.setDescription("describe");

       // contactDao.addContact(c);
//        hobbyDao.addHobby(h);



    }
}
