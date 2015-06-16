package com.dao.Interfaces;

import com.model.Contact;
import com.model.Message;

import java.util.List;

/**
 * Created by volodymyr on 15/06/15.
 */
public interface iMessageDao {
     void storeMessage(Message message);
     List<Message> getConversation(Contact firstcontact,Contact secondContact);
}
