package com.manuellugodev.datacrmappjava.framework.retrofit.model.response;

import com.google.gson.annotations.SerializedName;
import com.manuellugodev.datacrmappjava.framework.retrofit.model.ContactApi;

import java.util.List;

public class ContactsResponse {

    @SerializedName("success")
    private Boolean success;
    @SerializedName("result")
    private List<ContactApi> contacts;
    @SerializedName("error")
    private ErrorApi error;

    public Boolean getSuccess() {
        return success;
    }

    public List<ContactApi> getContacts() {
        return contacts;
    }

    public ErrorApi getError() {
        return error;
    }
}
