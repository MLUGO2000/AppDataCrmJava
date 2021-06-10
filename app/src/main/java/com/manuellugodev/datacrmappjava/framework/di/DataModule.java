package com.manuellugodev.datacrmappjava.framework.di;

import com.manuellugodev.datacrmappjava.data.repository.ContactsRepository;
import com.manuellugodev.datacrmappjava.data.repository.ContactsRepositoryImpl;
import com.manuellugodev.datacrmappjava.data.repository.LoginRepository;
import com.manuellugodev.datacrmappjava.data.repository.LoginRepositoryImpl;
import com.manuellugodev.datacrmappjava.data.sources.DataSourceContacts;
import com.manuellugodev.datacrmappjava.data.sources.SourceLogin;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    @Named("loginRepository")
    LoginRepository loginRepositoryProvider(@Named("sourceLogin")SourceLogin sourceLogin){
        return new LoginRepositoryImpl(sourceLogin);
    }

    @Provides
    @Singleton
    @Named("contactsRepository")
    ContactsRepository contactsRepositoryProvider(@Named("sourceContacts")DataSourceContacts dataSourceContacts){
        return new ContactsRepositoryImpl(dataSourceContacts);
    }
}
