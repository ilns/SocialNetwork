package com.logic.dao;


import com.logic.dao.interfaces.MessageDao;
import com.logic.model.Contact;
import com.logic.model.Message;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by volodymyr on 15/06/15.
 */
@Repository
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public void storeMessage(Message message) {
        sessionFactory.getCurrentSession().saveOrUpdate(message);
    }

    @Override
    @Transactional
    public void createNewMessageFromContactToContact(Contact contactFrom, Contact contactTo, String content) {
        Message message = new Message();
        message.setContent(content);;
        message.setFromContact(contactFrom);
        message.setToContact(contactTo);
        message.setDate(new Date());
        sessionFactory.getCurrentSession().saveOrUpdate(message );
    }


    @Override
    @Transactional
    public List<Message> getConversation(Contact firstcontact, Contact secondContact) {
        long from = firstcontact.getId();
        long to = secondContact.getId();
        String stringQuery = "from Message m where (m.from = :from and m.to = :to) or (m.to = :to and m.from = :from) order by m.date";
        return sessionFactory.getCurrentSession().createQuery(stringQuery).setParameter("from", from).setParameter("to", to).list();
    }
}

/* @Repository - (Доменный слой) Аннотация показывает, что класс функционирует как репозиторий и требует наличия прозрачной трансляции исключений.
 * Преимуществом трансляции исключений является то, что слой сервиса будет иметь дело с общей иерархией исключений от Spring (DataAccessException)
 * вне зависимости от используемых технологий доступа к данным в слое данных.*/