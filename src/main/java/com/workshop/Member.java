package com.workshop;

public class Member {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Member(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    // Getters for member attributes
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getDetails() {
        return "Name : " + name + ", address: " + address + ", phoneNumber: " + phoneNumber + ", email:" + emailAddress;
    }

}
