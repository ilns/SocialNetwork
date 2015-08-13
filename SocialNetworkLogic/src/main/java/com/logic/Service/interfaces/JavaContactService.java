package com.logic.Service.interfaces;

import com.logic.model.Contact;
import com.logic.model.Message;

import java.util.Date;
import java.util.List;

/**
 * Created by volodymyr on 15/06/15.
 */
public interface JavaContactService {
    void createContact(String firstname,String lastName, Date birthDay);
    void createContact(String firstname,String lastName);
    void addHobby(String title,String description);
    void addPlace(String title , String description , double longitude, double latitude);
    void addFriendShip(Contact firstContact, Contact lastContact);

    List<Contact> getFriendlist(Contact contact);
    List<Message> getConversation(Contact fromContact,Contact toContact) ;
}
