package com.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by volodymyr on 11/08/15.
 */
@Controller
public class PagesController {

    @RequestMapping("/")
    public String getIndex() {
        return "forward:/resources/index.html";
    }

    @RequestMapping("/html/contacts")
    public String getContactsPage() {
        return "forward:/resources/contacts.html";
    }

    @RequestMapping("/html/add-contact")
    public String getAddContactsPage() {
        return "forward:/resources/add-contact.html";
    }

    @RequestMapping("/html/messages")
    public String getMessagesPage() {
        return "forward:/resources/messages.html";
    }

    @RequestMapping("/html/add-hobby")
    public String getAddHobbyPage() {
        return "forward:/resources/add-hobby.html";
    }

    @RequestMapping("/html/add-place")
    public String getAddPlacePage() {
        return "forward:/resources/add-place.html";
    }
}
