package com.manuellugodev.datacrmappjava.data.repository;

import com.manuellugodev.datacrmappjava.data.sources.SourceLogin;
import com.manuellugodev.datacrmappjava.domain.login.LoginUser;
import com.manuellugodev.datacrmappjava.domain.login.Token;

import io.reactivex.Observable;

public class LoginRepositoryImpl implements LoginRepository {

    private SourceLogin sourceLogin;

    public LoginRepositoryImpl(SourceLogin source){
        sourceLogin=source;
    }


    @Override
    public Observable<Token> getToken(String userName) {
        return  sourceLogin.getTokenApi(userName);
    }

    @Override
    public Observable<LoginUser> loginUser(String userName, String password, String token) {
        return sourceLogin.sendLoginRequest(userName,password,token);
    }
}
