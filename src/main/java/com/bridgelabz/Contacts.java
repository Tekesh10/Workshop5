package com.bridgelabz;

public class Contacts {
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private String city;
    private String state;
    private String zipcode;
    public Contacts(String firstName, String lastName, String phoneNumber, String email, String city, String state, String zipcode) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.phone_number = phoneNumber;
        this.email = email;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    @Override
    public String toString() {
        return "First Name : '" + first_name + "', Last Name : '" + last_name + "', Phone Number : '" + phone_number +
                "', email ID : '" + email + "', City : '" + city + "', State : '" + state + "', Zipcode : '" + zipcode + "'\n";
    }
}