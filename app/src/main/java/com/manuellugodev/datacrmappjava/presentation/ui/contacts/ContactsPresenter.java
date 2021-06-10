package com.manuellugodev.datacrmappjava.presentation.ui.contacts;

import com.manuellugodev.datacrmappjava.data.repository.ContactsRepository;
import com.manuellugodev.datacrmappjava.domain.contact.Contact;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ContactsPresenter implements ContactsContracts.presenter{
    ContactsRepository contactsRepository;
    ContactsContracts.view view;

    public ContactsPresenter(ContactsContracts.view view,ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
        this.view=view;
    }

    @Override
    public void getContacts(String sessionName) {

        view.showProgress();

        contactsRepository.getContacts(sessionName).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::resultContacts,this::resultErrorContacts);

    }

    private void resultErrorContacts(Throwable throwable) {
        view.hideProgress();
        view.showMessage("Error :" + throwable.getMessage());
    }

    private void resultContacts(List<Contact> contacts) {
        view.hideProgress();
        view.showContacts(contacts);
    }
}
