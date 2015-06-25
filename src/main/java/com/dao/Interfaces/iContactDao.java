package com.dao.Interfaces;

import com.model.Contact;

/**
 * Created by volodymyr on 15/06/15.
 */
// TODO FIX ME strange name of the interface, see java convention
public interface iContactDao {
     void addContact(Contact contact);
     void deleteContact(Contact contact);
     void addFriendShip(Contact firstContact,Contact secondContact);
     void removeFrienShip(Contact firstContact,Contact secondContact);
}
