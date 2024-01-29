package org.example.Service;

import org.example.Exception.ContactException;
import org.example.Model.Contact;
import org.example.Main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class ContactService {
    List<Contact> contacts;

    public ContactService(){contacts = new ArrayList<>();
    }
// for logging you have to add logger log to your main class
    public void addContact(String name, String streetAddress, int phoneNumber, String emailAddress) throws ContactException {
        Main.log.info("log, adding a Contact." + name +"," + streetAddress +"," + phoneNumber +"," + emailAddress);
        if(phoneNumber == 0) {
            Main.log.warn("throwing Contact exception due to invalid characters Phone: "+ phoneNumber);
            throw new ContactException("Must enter numeric value");
        }else{
            if(name.isEmpty()){
            Main.log.warn("throwing Contact exception due to misformatted Name: "+ name);
            throw new ContactException("Must enter name");
            }
        }
        Contact c = new Contact(name, streetAddress, phoneNumber,emailAddress);
        contacts.add(c);
    }

    public List<Contact> getContact(){
        Main.log.info("Retrieving contacts: " + contacts);
        return contacts;

    }

    public Contact getContactByName(String name){
        for(int i = 0; i < contacts.size(); i=i+1) {
            Contact currentContact = contacts.get(i);
        if(currentContact.getName().equals(name)){
            return currentContact;
        }
    }

    return null;
    }

    public void deleteContact(String name) {
        Main.log.info ("Deleting contact." + name);
        Iterator<Contact> iterator = contacts.iterator();
            while (iterator.hasNext()) {
                Contact contact = iterator.next();
                if (contact.getName().equalsIgnoreCase(name)) {
                Main.log.warn("Deleting contact");
                    iterator.remove();
                    System.out.println("Contact deleted successfully");
                    return;


                }
            }
    }

}

