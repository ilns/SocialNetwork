package com.web.controllers;

import com.logic.dao.interfaces.ContactDao;
import com.logic.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by volodymyr on 15/08/15.
 */

@Controller
public class ContactController {

    @Autowired
    ContactDao contactDao;

    @RequestMapping(value = "/contacts.json", method = RequestMethod.GET)
    public @ResponseBody List<Contact> getAllContacts(){
        return contactDao.getAllContact();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add-contact", method = RequestMethod.POST)
    public @ResponseBody String addNewContract( @RequestParam("firstName") String firstName,
                                                @RequestParam("lastName") String lastName,
                                                @RequestParam("birthDay") String birthDay) {

        Contact contact = null;
        try {
            contact = new Contact(firstName,lastName, new SimpleDateFormat("dd-MM-yyyy").parse(birthDay));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        contactDao.addContact(contact);
        return "";
    }

    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String deleteContact(@RequestParam(value = "contact", required = true) String contact){
        List<Contact> contacts = contactDao.getAllContact();
//
//        for (Contact contact : contacts){
//            if (contact.getFirstName().equals(contacts)&&contact.getLastName().equals(contacts)){
//                contactDao.deleteContact(contact);
//            }
//
//        }
        return "ok";
    }



}
