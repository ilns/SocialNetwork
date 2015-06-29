package com.Service.interfaces;

import com.model.Contact;
import com.model.Message;
import org.joda.time.LocalDate;

import java.util.List;
import java.util.Set;

/**
 * Created by volodymyr on 15/06/15.
 */
// TODO FIX ME strange name of the interface, see java convention
public interface iJavaContactService {
    void createContact(String firstname,String lastName,LocalDate birthDay);
    void addHobby(String title,String description);
    void addPlace(String title , String description , double longitude, double latitude);
    void addFtrirnShip(Contact firstContact,Contact lastContact);
    Set<Contact> getFrienlist(Contact contact);
    List<Message> getConversation(Contact contact,Contact lastName) ;
}
