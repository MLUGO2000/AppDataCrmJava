package com.manuellugodev.datacrmappjava.data.repository;

import com.manuellugodev.datacrmappjava.data.sources.DataSourceContacts;
import com.manuellugodev.datacrmappjava.domain.contact.Contact;

import java.util.List;

import io.reactivex.Observable;

public class ContactsRepositoryImpl implements ContactsRepository {
    private DataSourceContacts sourceContacts;

    public ContactsRepositoryImpl(DataSourceContacts source){
        sourceContacts=source;
    }

    @Override
    public Observable<List<Contact>> getContacts(String sessionName) {
        return sourceContacts.getContacts(sessionName);
    }
}
