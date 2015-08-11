package com.logic.dao;


import com.logic.dao.Interfaces.HobbyDao;
import com.logic.model.Contact;
import com.logic.model.Hobby;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by volodymyr on 15/06/15.
 */
@Component
public class HobbyDaoImpl implements HobbyDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addHobby(Hobby hobby) {
//        Session session = this.sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        session.persist(hobby);
//        tx.commit();
//        session.close();
    }

    @Override
    public Set<Contact> getAllContactsWithHobby(Hobby hobby) {
        return null;
    }
}
