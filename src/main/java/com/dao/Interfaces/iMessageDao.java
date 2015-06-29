package com.dao.Interfaces;

import com.model.Contact;
import com.model.Message;

import java.util.List;

/**
 * Created by volodymyr on 15/06/15.
 */
// TODO FIX ME strange name of the interface, see java convention
public interface iMessageDao {
     void storeMessage(Message message);
     List<Message> getConversation(Contact firstcontact,Contact secondContact);
}
