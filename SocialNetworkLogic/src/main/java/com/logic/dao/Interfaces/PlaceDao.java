package com.logic.dao.Interfaces;

import com.logic.model.Contact;
import com.logic.model.Place;

import java.util.Set;

/**
 * Created by volodymyr on 15/06/15.
 */
// TODO FIX ME strange name of the interface, see java convention
public interface PlaceDao {
     void addPlace(Place place);
     Set<Contact> getAllContactsForPlace(Place place);
}
