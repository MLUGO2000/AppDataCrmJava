package com.manuellugodev.datacrmappjava.framework.sources;

import com.manuellugodev.datacrmappjava.data.sources.DataSourceContacts;
import com.manuellugodev.datacrmappjava.domain.contact.Contact;
import com.manuellugodev.datacrmappjava.framework.retrofit.DataCrmApiService;
import com.manuellugodev.datacrmappjava.framework.retrofit.model.ContactApi;
import com.manuellugodev.datacrmappjava.framework.retrofit.model.response.ContactsResponse;

import java.util.List;

import io.reactivex.Observable;

public class DataSourceContactsImpl implements DataSourceContacts {

    DataCrmApiService service;

    public DataSourceContactsImpl(DataCrmApiService service) {
        this.service=service;
    }

    @Override
    public Observable<List<Contact>> getContacts(String sessionName) {
        Observable<ContactsResponse> result=service.getContacts(sessionName);

        Observable<List<Contact>> listObservable= result.map(contactsResponse -> contactsResponse.getContacts())
                .flatMap(listTransforms->Observable.fromIterable(listTransforms)
                        .map(item->ContactApiToDomain(item))
                        .toList().toObservable());


        return listObservable;
    }

    Contact ContactApiToDomain(ContactApi contactApi){
        return new Contact(contactApi.getId(),contactApi.getContactNo(),contactApi.getLastName(),contactApi.getCreatedTime());
    }
}