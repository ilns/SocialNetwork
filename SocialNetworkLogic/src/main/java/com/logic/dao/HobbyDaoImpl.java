package com.logic.dao;


import com.logic.dao.interfaces.HobbyDao;
import com.logic.model.Contact;
import com.logic.model.Hobby;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by volodymyr on 15/06/15.
 */
@Repository
public class HobbyDaoImpl implements HobbyDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addHobby(Hobby hobby) {
        sessionFactory.getCurrentSession().saveOrUpdate(hobby);
    }

    @Override
    @Transactional
    public Set<Contact> getAllContactsWithHobby(Hobby hobby) {
        Set<Contact> contactSet = new HashSet<Contact>();
        List<Contact> contactList = sessionFactory.getCurrentSession().createQuery("from ContactHobbies").list();
        if (contactList == null)
            return null;
        for (Contact contact : contactList){
            contactSet.add(contact);
        }
        return contactSet;
    }
}

/* @Repository - (Доменный слой) Аннотация показывает, что класс функционирует как репозиторий и требует наличия прозрачной трансляции исключений.
 * Преимуществом трансляции исключений является то, что слой сервиса будет иметь дело с общей иерархией исключений от Spring (DataAccessException)
 * вне зависимости от используемых технологий доступа к данным в слое данных.*/