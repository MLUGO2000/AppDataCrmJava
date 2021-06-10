package com.manuellugodev.datacrmappjava.data.repository;

import com.manuellugodev.datacrmappjava.domain.login.LoginUser;
import com.manuellugodev.datacrmappjava.domain.login.Token;

import io.reactivex.Observable;

public interface LoginRepository {

    Observable<Token> getToken(String userName);

    Observable<LoginUser> loginUser(String userName,String password,String token);
}
