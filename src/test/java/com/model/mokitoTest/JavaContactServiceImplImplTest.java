package com.model.mokitoTest;

import com.Service.JavaContactServiceImpl;
import com.dao.ContactDaoImpl;
import com.dao.HobbyDaoImpl;
import com.dao.MessageDaoImpl;
import com.dao.PlaceDaoImpl;
import com.model.Contact;
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
public class JavaContactServiceImplImplTest {

    @Autowired
    private Contact contact;

    @Mock
    private ContactDaoImpl contactDaoImplImpl;
    @Mock
    private HobbyDaoImpl hobbyDaoImplImpl;
    @Mock
    private PlaceDaoImpl placeDaoImplImpl;
    @Mock
    private MessageDaoImpl messageDaoImplImpl;

    @InjectMocks
    private JavaContactServiceImpl mokedJavaContactServiceImplImpl = new JavaContactServiceImpl();

    @Test
    public void testCreateContact() throws Exception{
        mokedJavaContactServiceImplImpl.createContact("Vova", "Zinchenko", any(LocalDate.class));
        verify(contactDaoImplImpl).addContact((Contact) anyObject());

        mokedJavaContactServiceImplImpl.createContact("Alex", "Zinchenko", any(LocalDate.class));
        verify(contactDaoImplImpl, times(2)).addContact((Contact) anyObject());

    }

    @Test
    public void testAddPlace() throws Exception {
        mokedJavaContactServiceImplImpl.addPlace("one", "two", 1.1, 2.2);
        verify(placeDaoImplImpl).addPlace((Place) anyObject());
    }

    @Test
    public void testAddFriendShip() throws Exception {
        Contact contact1 = new Contact();
        Contact contact2 = new Contact();
        mokedJavaContactServiceImplImpl.addFriendShip(contact1, contact2);
        verify(contactDaoImplImpl).addFriendShip(isA(Contact.class), isA(Contact.class));
    }

    @Test
    public void testGetConversation() throws Exception {
        when(mokedJavaContactServiceImplImpl.getConversation((Contact) anyObject(), (Contact) anyObject())).thenReturn(Collections.EMPTY_LIST);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteContact() throws Exception {
        contact.setFirstName("a");
        contact.setLastName("aa");
        verify(contactDaoImplImpl).deleteContact(contact);
    }

    @Test
    public void testCreatContactAndFaindTheMaches() throws Exception{

        JavaContactServiceImpl mockJavaContactServiceImplImpl = mock(JavaContactServiceImpl.class);

        LocalDate dt = new LocalDate(1993, 12, 3);

        mockJavaContactServiceImplImpl.createContact("Vova", "Zinchenko", dt);

        InOrder inOrder = inOrder(mockJavaContactServiceImplImpl);

        inOrder.verify(mockJavaContactServiceImplImpl).createContact("Vova", "Zinchenko", dt);

    }

}
