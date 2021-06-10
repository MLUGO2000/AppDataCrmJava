package com.manuellugodev.datacrmappjava.data.sources;

import com.manuellugodev.datacrmappjava.domain.contact.Contact;

import java.util.List;

import io.reactivex.Observable;

public interface DataSourceContacts {

    Observable<List<Contact>> getContacts(String sessionName);

}
