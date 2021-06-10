package com.manuellugodev.datacrmappjava.presentation.ui.contacts;

import com.manuellugodev.datacrmappjava.domain.contact.Contact;

import java.util.List;

public interface ContactsContracts {

    interface view{
        void showMessage(String message);
        void showContacts(List<Contact> contactList);
        void showProgress();
        void hideProgress();
    }

    interface presenter{
        void getContacts(String sessionName);
    }
}
