package com.manuellugodev.datacrmappjava.framework.di;

import com.manuellugodev.datacrmappjava.data.sources.DataSourceContacts;
import com.manuellugodev.datacrmappjava.data.sources.SourceLogin;
import com.manuellugodev.datacrmappjava.framework.retrofit.DataCrmApiService;
import com.manuellugodev.datacrmappjava.framework.sources.DataSourceContactsImpl;
import com.manuellugodev.datacrmappjava.framework.sources.LoginApiDataCrm;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Named("sourceLogin")
    SourceLogin sourceLoginProvider(@Named("ApiService")DataCrmApiService service){
        return new LoginApiDataCrm(service);
    }

    @Provides
    @Named("sourceContacts")
    DataSourceContacts sourceContactsProvider(@Named("ApiService") DataCrmApiService service){
        return new DataSourceContactsImpl(service);
    }

}
