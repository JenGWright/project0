import org.example.Exception.ContactException;
import org.example.Model.Contact;
import org.example.Service.ContactService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class ContactServiceTest {

    ContactService contactService;
// put @Before test so it resets the contact service
    @Before
    public void setUP(){
        contactService = new ContactService();
    }

    // when the  contact service is first created, it shouldn't contain any recipes
    @Test
    public void contactServiceEmptyAtStart(){
        List<Contact> contactList = contactService.getContact();
        Assert.assertTrue(contactList.size() == 0);
    }

    @Test
    public void contactServiceAddContact() {
        String testName = "name";
        String testStreetAddress = "street";
        int testPhoneNumber = 999999999;
        String testEmailAddress = "email";
        try {
            contactService.addContact(testName, testStreetAddress, testPhoneNumber, testEmailAddress);
        } catch (ContactException e) {
//            if the contact exception is thrown, that is in correct behavior and the test should fail
            e.printStackTrace();
            Assert.fail("contact exception incorrectly thrown");
        }
        List<Contact> contacts = contactService.getContact();
        Contact actual = contacts.get(0);
        Assert.assertEquals(testName, actual.getName());
        Assert.assertEquals(testStreetAddress, actual.getStreetAddress());
        Assert.assertEquals(testPhoneNumber, actual.getPhoneNumber());


    }
    @Test
    public void addContactInvalidPhone(){
        String testName = "name";
        String testStreetAddress = "street";
        int testPhoneNumber = -999999999;
        String testEmailAddress = "email";
        try{
            contactService.addContact(testName,testStreetAddress, testPhoneNumber, testEmailAddress);
       }catch(ContactException e) {



        }
    }
}
