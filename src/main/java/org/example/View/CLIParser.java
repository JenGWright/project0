package org.example.View;

import jdk.jshell.spi.ExecutionControl;
import org.example.Exception.CLIException;
import org.example.Exception.ContactException;
import org.example.Model.Contact;
import org.example.Service.ContactService;

import java.util.List;
import java.util.Scanner;

public class CLIParser {

    ContactService contactService;

    public CLIParser(){
        contactService = new ContactService();

    }

    public String parseCommandReturnOutput(String command) throws CLIException, ContactException {
        switch(command) {
            case "add":
                return interpretAddAction();
            case "view":
                return interpretViewAction();
            case "delete":
                return interpretDeleteAction();
            case "stop":
                return "stop";
            default:
                throw new CLIException("not a valid command");

        }




 /*       if(command.equals("add")){
            return interpretAddAction();
        }else if(command.equals("view")){
            return interpretViewAction();
        }else{
            throw new CLIException("not a valid command");
        }

        orig had if else, changed to switch when added delete and stop
*/
    }
    public String interpretAddAction() throws ContactException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name");
        String nameInput = sc.nextLine();
        System.out.println("Enter street address");
        String streetAddressinput = sc.nextLine();
        System.out.println("Enter Phone Number excluding dashes");
        String phoneNumberInputString = sc.nextLine();
        int phone;
        try{
            phone = Integer.parseInt(phoneNumberInputString);
        } catch (NumberFormatException exception){
            System.out.println("Must enter numerical value");
            phoneNumberInputString = sc.nextLine();
            phone = Integer.parseInt(phoneNumberInputString);
        }
        System.out.println("Enter Email Address");
        String emailAddressInput = sc.nextLine();
        contactService.addContact(nameInput, streetAddressinput, phone, emailAddressInput);
        return "New contact added successfully";
    }
    public String interpretViewAction(){
        List<Contact> contacts = contactService.getContact();
        return "Contact list " + contacts.toString();
    }

    public String  interpretDeleteAction() throws ContactException {
        //first retrieve contact list
        //check if list is empty if list throw exception
        //display contact list to user
        //ask user which contact to delete
        //delete entry from contact
        Scanner sc = new Scanner(System.in);
        List<Contact> contacts = contactService.getContact();
        if (contacts.isEmpty()){
            throw new ContactException("No contacts exist");
        }
        System.out.println(contacts.toString());
        System.out.println("Enter contact name you want to delete");
        String nameInput = sc.nextLine();
        contactService.deleteContact(nameInput);
        return "";




    }


    // public <return type> <methodName>() {  // do logic if need to return "return datatype"}
}
