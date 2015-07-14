package com.Service;
//package com.Service.interfaces.;

import com.Service.interfaces.JavaContactService;
import com.dao.ContactDaoImpl;
import com.dao.HobbyDaoImpl;
import com.dao.MessageDaoImpl;
import com.dao.PlaceDaoImpl;
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
public class JavaContactServiceImpl implements JavaContactService {

    @Autowired
    private ContactDaoImpl contactDaoImplImpl;
    @Autowired
    private HobbyDaoImpl hobbyDaoImplImpl;
    @Autowired
    private PlaceDaoImpl placeDaoImplImpl;
    @Autowired
    private MessageDaoImpl messageDaoImplImpl;

    @Override
    public void createContact(String firstname, String lastName, LocalDate birthDay) {
        contactDaoImplImpl.addContact(new Contact(firstname, lastName, birthDay));
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
        contactDaoImplImpl.addFriendShip(firstContact, secondContact);
    }

    @Override
    public Set<Contact> getFriendlist(Contact contact) {
        return contact.getFriends();
    }

    @Override
    public List<Message> getConversation(Contact firstcontact, Contact secondcontact) {
        return messageDaoImplImpl.getConversation(firstcontact, secondcontact);
    }
}
