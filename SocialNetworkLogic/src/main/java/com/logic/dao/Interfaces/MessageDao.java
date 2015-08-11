package com.logic.dao.Interfaces;

import com.logic.model.Contact;
import com.logic.model.Message;

import java.util.List;

/**
 * Created by volodymyr on 15/06/15.
 */
// TODO FIX ME strange name of the interface, see java convention
public interface MessageDao {
     void storeMessage(Message message);
     List<Message> getConversation(Contact firstcontact,Contact secondContact);
}
