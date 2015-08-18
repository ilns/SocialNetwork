package com.logic.dao;


import com.logic.dao.interfaces.ContactDao;
import com.logic.model.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by volodymyr on 15/06/15.
 */
@Repository
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addOrUpdateContact(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
    }

    @Override
    @Transactional
    public List<Contact> getAllContact() {
        String strQuery = "from Contact";
        List<Contact> contactList = sessionFactory.getCurrentSession().createQuery(strQuery).list();
        if (contactList == null) {
            return null;
        }
        return contactList;
    }

    @Override
    @Transactional
    public List<Contact> getAllFriendsFromContact(Contact contact) {
        long id = contact.getId();
        String strQuery = " from List_friends where Contact_id_one=:id";
        return sessionFactory.getCurrentSession().createQuery(strQuery).setParameter("id", id).list();
    }

    @Override
    @Transactional
    public void deleteContact(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);
    }

    @Override
    @Transactional
    public void addFriendShip(Contact firstContact, Contact secondContact) {
        firstContact.getFriends().add(secondContact);
        secondContact.getFriends().add(firstContact);
        sessionFactory.getCurrentSession().saveOrUpdate(firstContact);
        sessionFactory.getCurrentSession().saveOrUpdate(secondContact);
    }

    @Override
    @Transactional
    public void removeFrienShip(Contact firstContact, Contact secondContact) {
        firstContact.getFriends().remove(secondContact);
        secondContact.getFriends().remove(firstContact);
        sessionFactory.getCurrentSession().saveOrUpdate(firstContact);
        sessionFactory.getCurrentSession().saveOrUpdate(secondContact);
    }
}
/* @Repository - (Доменный слой) Аннотация показывает, что класс функционирует как репозиторий и требует наличия прозрачной трансляции исключений.
 * Преимуществом трансляции исключений является то, что слой сервиса будет иметь дело с общей иерархией исключений от Spring (DataAccessException)
 * вне зависимости от используемых технологий доступа к данным в слое данных.*/