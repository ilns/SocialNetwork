package com.web.controllers;

import com.logic.dao.interfaces.ContactDao;
import com.logic.dao.interfaces.PlaceDao;
import com.logic.model.Contact;
import com.logic.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by volodymyr on 18/08/15.
 */
@Controller
public class PlaceController {

    @Autowired
    ContactDao contactDao;

    @Autowired
    PlaceDao placeDao;

    @RequestMapping(value = "/add-place", method = RequestMethod.POST)
    public @ResponseBody
    String addNewPlaces( @RequestParam("contactIds") String contactIds,
                         @RequestParam("title") String title,
                         @RequestParam("description") String description,
                         @RequestParam("longitude") double longitude,
                         @RequestParam("latitude") double latitude) {

        Place place = new Place(title,description,longitude,latitude);
        placeDao.addPlace(place);

        String [] contactIdsArr = contactIds.split(",");
        List<Contact> contacts = contactDao.getAllContact();
        for (Contact contact: contacts) {
            for (String contactId: contactIdsArr) {
                if (contact.getId() == Long.parseLong(contactId)) {
                    contact.getPlaces().add(place);
                    contactDao.addOrUpdateContact(contact);
                }
            }
        }
        return "";
    }
}
