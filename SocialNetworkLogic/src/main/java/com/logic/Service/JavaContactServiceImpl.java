package com.logic.Service;

import com.logic.Service.interfaces.JavaContactService;
import com.logic.dao.HobbyDaoImpl;
import com.logic.dao.Interfaces.ContactDao;
import com.logic.dao.MessageDaoImpl;
import com.logic.dao.PlaceDaoImpl;
import com.logic.model.Contact;
import com.logic.model.Hobby;
import com.logic.model.Message;
import com.logic.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by volodymyr on 15/06/15.
 */
@Service
public class JavaContactServiceImpl implements JavaContactService {

    @Autowired
    ContactDao contactDao;

//    @Autowired
    HobbyDaoImpl hobbyDaoImplImpl;

//    @Autowired
    PlaceDaoImpl placeDaoImplImpl;

//    @Autowired
    MessageDaoImpl messageDaoImplImpl;


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
    public void addHobby(String title, String description) {
        hobbyDaoImplImpl.addHobby(new Hobby(title, description));
    }

    @Override
    public void addPlace(String title, String description, double longitude, double latitude) {
        placeDaoImplImpl.addPlace(new Place(title, description, longitude, latitude));
    }


    @Override
    public void addFriendShip(Contact firstContact, Contact secondContact) {
        contactDao.addFriendShip(firstContact, secondContact);
    }

    @Override
    public Set<Contact> getFriendlist(Contact contact) {
        return null;
    }

    @Override
    public List<Message> getConversation(Contact firstcontact, Contact secondcontact) {
        return messageDaoImplImpl.getConversation(firstcontact, secondcontact);
    }
}
