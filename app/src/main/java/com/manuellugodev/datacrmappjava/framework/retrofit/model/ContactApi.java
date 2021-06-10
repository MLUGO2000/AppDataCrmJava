package com.manuellugodev.datacrmappjava.framework.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class ContactApi {
    public ContactApi(){}
    @SerializedName("id")
    private String id;
    @SerializedName("contact_no")
    private String contactNo;
    @SerializedName("lastname")
    private String lastName;
    @SerializedName("createdtime")
    private String createdTime;

    public String getId() {
        return id;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCreatedTime() {
        return createdTime;
    }
}
