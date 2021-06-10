package com.manuellugodev.datacrmappjava.framework;

import android.app.Application;

import com.manuellugodev.datacrmappjava.framework.di.AppComponent;
import com.manuellugodev.datacrmappjava.framework.di.DaggerAppComponent;


public class DataCrmAppJava extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent= DaggerAppComponent.create();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
