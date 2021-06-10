package com.manuellugodev.datacrmappjava.data.repository;

import com.manuellugodev.datacrmappjava.domain.contact.Contact;

import java.util.List;

import io.reactivex.Observable;

public interface ContactsRepository {

    Observable<List<Contact>> getContacts(String sessionName);
}
