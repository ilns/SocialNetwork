package com.logic.dao.interfaces;

import com.logic.model.Contact;

import java.util.List;

/**
 * Created by volodymyr on 15/06/15.
 */
// TODO FIX ME strange name of the interface, see java convention
public interface ContactDao {
     void addContact(Contact contact);
     List<Contact> getAllContact();
     List<Contact> getAllFriendsFromContact(Contact contact);
     void deleteContact(Contact contact);
     void addFriendShip(Contact firstContact,Contact secondContact);
     void removeFrienShip(Contact firstContact,Contact secondContact);
}
