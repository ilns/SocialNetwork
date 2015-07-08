package com.model.mokitoTest;

import com.Service.JavaContactService;
import com.dao.ContactDao;
import com.dao.HobbyDao;
import com.dao.MessageDao;
import com.dao.PlaceDao;
import com.model.Contact;
import com.model.Hobby;
import com.model.Message;
import com.model.Place;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

/**
 * Created by volodymyr on 06/07/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class JavaContactServiceTest {
    @Autowired
    private Contact contact;
    @Autowired
    private Hobby hobby;
    @Autowired
    private Message message;
    @Autowired
    private Place place;


    @Mock
    private ContactDao contactDao;
    @Mock
    private HobbyDao hobbyDao;
    @Mock
    private PlaceDao placeDao;
    @Mock
    private MessageDao messageDao;

    @InjectMocks
    private JavaContactService mokedJavaContactService = new JavaContactService();

    @Test
    public void testCreateContact() throws Exception{
        mokedJavaContactService.createContact("Vova", "Zinchenko", any(LocalDate.class));
        verify(contactDao).addContact((Contact) anyObject());

        mokedJavaContactService.createContact("Alex", "Zinchenko", any(LocalDate.class));
        verify(contactDao, times(2)).addContact((Contact) anyObject());

    }

    @Test
    public void testAddPlace() throws Exception {
        mokedJavaContactService.addPlace("one", "two", 1.1, 2.2);
        verify(placeDao).addPlace((Place) anyObject());
    }

    @Test
    public void testAddFriendShip() throws Exception {
        Contact contact1 = new Contact();
        Contact contact2 = new Contact();
        mokedJavaContactService.addFriendShip(contact1, contact2);
        verify(contactDao).addFriendShip(isA(Contact.class), isA(Contact.class));
    }

    @Test
    public void testGetConversation() throws Exception {
        when(mokedJavaContactService.getConversation((Contact) anyObject(), (Contact) anyObject())).thenReturn(Collections.EMPTY_LIST);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteContact() throws Exception {
        contact.setFirstName("a");
        contact.setLastName("aa");
        verify(contactDao).deleteContact(contact);
    }

    @Test
    public void testCreatContactAndFaindTheMaches() throws Exception{
        JavaContactService mockJavaContactService = mock(JavaContactService.class);

        LocalDate dt = new LocalDate(1993, 12, 3);

        mockJavaContactService.createContact("Vova", "Zinchenko", dt);

        InOrder inOrder = inOrder(mockJavaContactService);

        inOrder.verify(mockJavaContactService).createContact("Vova", "Zinchenko", dt);

    }

}
