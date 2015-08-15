package com.logic.dao;


import com.logic.dao.interfaces.PlaceDao;
import com.logic.model.Contact;
import com.logic.model.Place;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by volodymyr on 15/06/15.
 */
@Repository
public class PlaceDaoImpl implements PlaceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addPlace(Place place) {
        sessionFactory.getCurrentSession().saveOrUpdate(place);
    }

    @Override
    @Transactional
    public void deletePlace(Place place) {
        sessionFactory.getCurrentSession().delete(place);
    }

    @Override
    public Set<Contact> getAllContactsForPlace(Place place) {
        return null;
    }
}

/* @Repository - (Доменный слой) Аннотация показывает, что класс функционирует как репозиторий и требует наличия прозрачной трансляции исключений.
 * Преимуществом трансляции исключений является то, что слой сервиса будет иметь дело с общей иерархией исключений от Spring (DataAccessException)
 * вне зависимости от используемых технологий доступа к данным в слое данных.*/