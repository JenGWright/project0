package org.example.Model;

public class Contact {
    private String name;

    private String streetAddress;

    private int phoneNumber;

    private String emailAddress;


    public Contact(String name, String streetAddress, int phoneNumber, String emailAddress) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }


    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {return emailAddress;}

    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}

// you can generate the toString automatically but clean it up
    @Override
    public String toString() {
        return "Name: " + name + ", Street Address: " + streetAddress + ", Phone Number: " + phoneNumber + ", Email:" + emailAddress;

    }
}


