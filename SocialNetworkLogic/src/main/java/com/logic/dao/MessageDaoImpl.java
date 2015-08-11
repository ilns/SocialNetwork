package com.logic.dao;


import com.logic.dao.Interfaces.MessageDao;
import com.logic.model.Contact;
import com.logic.model.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volodymyr on 15/06/15.
 */
@Component
public class MessageDaoImpl implements MessageDao {

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
