package com.dao;


import com.dao.Interfaces.iMessageDao;
import com.model.Contact;
import com.model.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volodymyr on 15/06/15.
 */
@Component
public class MessageDao implements iMessageDao {

    private List<Message> messages = new ArrayList<>();

    @Override
    public void storeMessage(Message message) {
        messages.add(message);
    }

    @Override
    public List<Message> getConversation(Contact firstcontact, Contact secondContact) {
        List<Message> result = new ArrayList<>();
        for (Message message : result){
            if (message.getFrom().equals(firstcontact) && message.getTo().equals(secondContact) ||
                    message.getFrom().equals(secondContact) && message.getTo().equals(firstcontact))
                result.add(message);
        }
        return result;
    }
}
