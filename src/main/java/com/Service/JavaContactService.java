package com.Service;
//package com.Service.interfaces.;

import com.Service.interfaces.iJavaContactService;
import com.dao.ContactDao;
import com.dao.HobbyDao;
import com.dao.MessageDao;
import com.dao.PlaceDao;
import com.model.Contact;
import com.model.Hobby;
import com.model.Message;
import com.model.Place;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Created by volodymyr on 15/06/15.
 */
@Component
public class JavaContactService implements iJavaContactService {

    @Autowired
    private ContactDao contactDao;
    @Autowired
    private HobbyDao hobbyDao;
    @Autowired
    private PlaceDao placeDao;
    @Autowired
    private MessageDao messageDao;

    @Override
    public void createContact(String firstname, String lastName, LocalDate birthDay) {
        contactDao.addContact(new Contact(firstname, lastName, birthDay));
    }

    @Override
    public void addHobby(String title, String description) {
        hobbyDao.addHobby(new Hobby(title, description));
    }

    @Override
    public void addPlace(String title, String description, double longitude, double latitude) {
        placeDao.addPlace(new Place(title, description, longitude, latitude));
    }


    @Override
    public void addFriendShip(Contact firstContact, Contact secondContact) {
        contactDao.addFriendShip(firstContact, secondContact);
    }

    @Override
    public Set<Contact> getFriendlist(Contact contact) {
        return contact.getFriends();
    }

    @Override
    public List<Message> getConversation(Contact firstcontact, Contact secondcontact) {
        return messageDao.getConversation(firstcontact, secondcontact);
    }
}
