package com.dao;


import com.dao.Interfaces.PlaceDao;
import com.model.Contact;
import com.model.Place;
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
