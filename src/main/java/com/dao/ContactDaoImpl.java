package com.dao;


import com.dao.Interfaces.ContactDao;
import com.model.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by volodymyr on 15/06/15.
 */
@Repository
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
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
