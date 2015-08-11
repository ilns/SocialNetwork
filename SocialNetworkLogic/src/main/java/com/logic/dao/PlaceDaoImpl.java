package com.logic.dao;


import com.logic.dao.Interfaces.PlaceDao;
import com.logic.model.Contact;
import com.logic.model.Place;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by volodymyr on 15/06/15.
 */
@Component
public class PlaceDaoImpl implements PlaceDao {

    @Override
    public void addPlace(Place place) {

    }

    @Override
    public Set<Contact> getAllContactsForPlace(Place place) {
        return null;
    }
}
