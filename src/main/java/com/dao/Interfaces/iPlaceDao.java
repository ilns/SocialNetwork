package com.dao.Interfaces;

import com.model.Contact;
import com.model.Place;

import java.util.Set;

/**
 * Created by volodymyr on 15/06/15.
 */
public interface iPlaceDao {
     void addPlace(Place place);
     Set<Contact> getAllContactsForPlace(Place place);
}
