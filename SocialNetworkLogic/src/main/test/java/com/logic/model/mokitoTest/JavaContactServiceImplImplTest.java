package java.com.logic.model.mokitoTest;

import com.logic.Service.JavaContactServiceImpl;
import com.logic.dao.ContactDaoImpl;
import com.logic.dao.HobbyDaoImpl;
import com.logic.dao.MessageDaoImpl;
import com.logic.dao.PlaceDaoImpl;
import com.logic.model.Contact;
import com.logic.model.Place;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

/**
 * Created by volodymyr on 06/07/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class JavaContactServiceImplImplTest {

    private Contact contact;

    @Mock
    private ContactDaoImpl contactDaoImplImpl;
    @Mock
    private HobbyDaoImpl hobbyDaoImplImpl;
    @Mock
    private PlaceDaoImpl placeDaoImplImpl;

    @Mock
    private MessageDaoImpl messageDaoImplImpl;

    @Before
    public void init() {
        contact = new Contact();
    }



    @InjectMocks
    private JavaContactServiceImpl mokedJavaContactServiceImplImpl = new JavaContactServiceImpl();

    @Test
    public void testCreateContact() throws Exception{
        mokedJavaContactServiceImplImpl.createContact("Vova", "Zinchenko");
        verify(contactDaoImplImpl).addOrUpdateContact((Contact) anyObject());

        mokedJavaContactServiceImplImpl.createContact("Alex", "Zinchenko");
        verify(contactDaoImplImpl, times(2)).addOrUpdateContact((Contact) anyObject());

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


        mockJavaContactServiceImplImpl.createContact("Vova", "Zinchenko");

        InOrder inOrder = inOrder(mockJavaContactServiceImplImpl);

        inOrder.verify(mockJavaContactServiceImplImpl).createContact("Vova", "Zinchenko");

    }

}
