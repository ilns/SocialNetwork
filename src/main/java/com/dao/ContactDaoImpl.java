package com.dao;


import com.dao.Interfaces.ContactDao;
import com.model.Contact;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volodymyr on 15/06/15.
 */
@Component
public class ContactDaoImpl implements ContactDao {
    private List<Contact> contacts = new ArrayList<Contact>();
    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public void addFriendShip(Contact firstContact, Contact secondContact) {
        firstContact.getFriends().add(secondContact);
    }

    @Override
    public void removeFrienShip(Contact firstContact, Contact secondContact) {
        firstContact.getFriends().remove(secondContact);
    }
}
