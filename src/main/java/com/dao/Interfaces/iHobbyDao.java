package com.dao.Interfaces;

import com.model.Contact;
import com.model.Hobby;

import java.util.Set;

/**
 * Created by volodymyr on 15/06/15.
 */
public interface iHobbyDao {
     void addHobby(Hobby hobby);
     Set<Contact> getAllContactsWithHobby(Hobby hobby);
}
