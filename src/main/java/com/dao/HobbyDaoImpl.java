package com.dao;


import com.dao.Interfaces.HobbyDao;
import com.model.Contact;
import com.model.Hobby;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by volodymyr on 15/06/15.
 */
@Component
public class HobbyDaoImpl implements HobbyDao {

    @Override
    public void addHobby(Hobby hobby) {

    }

    @Override
    public Set<Contact> getAllContactsWithHobby(Hobby hobby) {
        return null;
    }
}
