package com;

import com.dao.ContactDaoImpl;
import com.dao.HobbyDaoImpl;
import com.dao.Interfaces.ContactDao;
import com.dao.Interfaces.HobbyDao;
import com.model.Contact;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by volodymyr on 15/06/15.
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ContactDao contactDao = context.getBean(ContactDaoImpl.class);
        HobbyDao hobbyDao = context.getBean(HobbyDaoImpl.class);

//        LocalDate localDate = new LocalDate(1993, 12, 3);

        Contact c = new Contact();
        c.setFirstName("Vova");
        c.setLastName("Zinchenko");
//        c.setBirthDay(localDate);

//        Hobby h = new Hobby();
//        h.setTitle("title");
//        h.setDescription("describe");

        contactDao.addContact(c);
//        hobbyDao.addHobby(h);



    }
}
