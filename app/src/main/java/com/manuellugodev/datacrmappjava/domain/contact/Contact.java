package com.manuellugodev.datacrmappjava.domain.contact;

public class Contact {
    private String id;
    private String contactNo;
    private String lastName;
    private String createdTime;

    public Contact(String id, String contactNo, String lastName, String createdTime) {
        this.id = id;
        this.contactNo = contactNo;
        this.lastName = lastName;
        this.createdTime = createdTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
