package com.dao.Interfaces;

import com.model.Contact;

/**
 * Created by volodymyr on 15/06/15.
 */
public interface iContactDao {
     void addContact(Contact contact);
     void deleteContact(Contact contact);
     void addFriendShip(Contact firstContact,Contact secondContact);
     void removeFrienShip(Contact firstContact,Contact secondContact);
}
