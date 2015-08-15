package com.logic.Service;

import com.logic.Service.interfaces.JavaContactService;
import com.logic.dao.interfaces.ContactDao;
import com.logic.dao.interfaces.HobbyDao;
import com.logic.dao.interfaces.MessageDao;
import com.logic.dao.interfaces.PlaceDao;
import com.logic.model.Contact;
import com.logic.model.Hobby;
import com.logic.model.Message;
import com.logic.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by volodymyr on 15/06/15.
 */
@Service
public class JavaContactServiceImpl implements JavaContactService {

    @Autowired
    ContactDao contactDao;

    @Autowired
    HobbyDao hobbyDao;

    @Autowired
    PlaceDao placeDao;

    @Autowired
    MessageDao messageDao;


    @Override
    @Transactional
    public void createContact(String firstName, String lastName, Date birthDay) {
        contactDao.addContact(new Contact(firstName, lastName, birthDay));
    }

    @Override
    @Transactional
    public void createContact(String firstName, String lastName) {
        contactDao.addContact(new Contact(firstName, lastName));
    }

    @Override
    @Transactional
    public void addHobby(String title, String description) {
        hobbyDao.addHobby(new Hobby(title, description));
    }

    @Override
    @Transactional
    public void addPlace(String title, String description, double longitude, double latitude) {
        placeDao.addPlace(new Place(title, description, longitude, latitude));
    }


    @Override
    @Transactional
    public void addFriendShip(Contact firstContact, Contact secondContact) {
        contactDao.addFriendShip(firstContact, secondContact);
    }

    @Override
    @Transactional
    public List<Contact> getFriendlist(Contact contact) {
        return contactDao.getAllFriendsFromContact(contact);
    }

    @Override
    @Transactional
    public List<Message> getConversation(Contact fromContact, Contact toContact) {
        return messageDao.getConversation(fromContact, toContact);
    }
}
