package com.manuellugodev.datacrmappjava.framework.di;

import com.manuellugodev.datacrmappjava.presentation.ui.contacts.MainActivity;
import com.manuellugodev.datacrmappjava.presentation.ui.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class,DataModule.class,RequestModule.class})
public interface AppComponent {

     void inject(LoginActivity loginActivity);
     void inject(MainActivity mainActivity);

}
