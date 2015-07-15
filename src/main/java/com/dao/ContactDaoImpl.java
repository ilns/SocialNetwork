package com.dao;


import com.dao.Interfaces.ContactDao;
import com.model.Contact;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by volodymyr on 15/06/15.
 */
@Component
public class ContactDaoImpl implements ContactDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void addContact(Contact contact) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(contact);
        tx.commit();
        session.close();
    }

    @Override
    public void deleteContact(Contact contact) {

    }

    @Override
    public void addFriendShip(Contact firstContact, Contact secondContact) {
//        firstContact.getFriends().add(secondContact);
    }

    @Override
    public void removeFrienShip(Contact firstContact, Contact secondContact) {
//        firstContact.getFriends().remove(secondContact);
    }
}
