package com.manuellugodev.datacrmappjava.data.sources;

import com.manuellugodev.datacrmappjava.domain.login.LoginUser;
import com.manuellugodev.datacrmappjava.domain.login.Token;

import io.reactivex.Observable;

public interface SourceLogin {

    Observable<Token> getTokenApi(String userName);

    Observable<LoginUser> sendLoginRequest(String userName,String password,String token);
}
