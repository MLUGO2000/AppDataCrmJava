package com.manuellugodev.datacrmappjava.framework.di;

import com.manuellugodev.datacrmappjava.framework.retrofit.Constans;
import com.manuellugodev.datacrmappjava.framework.retrofit.DataCrmApiService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RequestModule {

    @Provides
    @Singleton
    @Named("baseUrl")
    String baseUrlProvider(){
        return Constans.BASE_URL;
    }

    @Provides
    @Singleton
    @Named("client")
    OkHttpClient clientHttpProvider(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        return client;
    }

    @Provides
    @Singleton
    @Named("buildRetrofit")
    Retrofit buildRetrofitProvider(@Named("baseUrl") String baseUrl,@Named("client") OkHttpClient client){


        Retrofit builder=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return builder;
    }

    @Provides
    @Singleton
    @Named("ApiService")
    DataCrmApiService ApiServiceProvider(@Named("buildRetrofit") Retrofit buildRetrofit){
       return buildRetrofit.create(DataCrmApiService.class);
    }
}
