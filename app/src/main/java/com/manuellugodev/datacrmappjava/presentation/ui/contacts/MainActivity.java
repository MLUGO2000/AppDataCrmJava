package com.manuellugodev.datacrmappjava.presentation.ui.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.manuellugodev.datacrmappjava.R;
import com.manuellugodev.datacrmappjava.data.repository.ContactsRepository;
import com.manuellugodev.datacrmappjava.databinding.ActivityMainBinding;
import com.manuellugodev.datacrmappjava.domain.contact.Contact;
import com.manuellugodev.datacrmappjava.framework.DataCrmAppJava;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity implements ContactsContracts.view {

    ContactsContracts.presenter presenter;

    @Inject
    @Named("contactsRepository")
    ContactsRepository repository;

    ActivityMainBinding mainBinding;

    AdapterContacts adapterContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((DataCrmAppJava)getApplicationContext()).getAppComponent().inject(this);

        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());

        presenter=new ContactsPresenter(this,repository);

        setContentView(mainBinding.getRoot());
        adapterContacts= new AdapterContacts(this);

        mainBinding.RecyclerViewContacts.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mainBinding.RecyclerViewContacts.setAdapter(adapterContacts);

        String session=getIntent().getExtras().get("sessionName").toString();

        presenter.getContacts(session);



    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showContacts(List<Contact> contactList) {
        adapterContacts.updateDataList(contactList);
    }

    @Override
    public void showProgress(){
        mainBinding.loadingContacts.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress(){
        mainBinding.loadingContacts.setVisibility(View.GONE);
    }
}