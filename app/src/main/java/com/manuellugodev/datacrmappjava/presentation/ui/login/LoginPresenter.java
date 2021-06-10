package com.manuellugodev.datacrmappjava.presentation.ui.login;

import android.annotation.SuppressLint;

import com.manuellugodev.datacrmappjava.data.repository.LoginRepository;
import com.manuellugodev.datacrmappjava.domain.login.LoginUser;
import com.manuellugodev.datacrmappjava.domain.login.Token;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements LoginContracts.presenter {

    LoginRepository repository;
    LoginContracts.view view;

    public LoginPresenter(LoginContracts.view viewLogin,LoginRepository repository){
        this.repository=repository;
        view=viewLogin;
    }

    @Override
    public void sendRequestToken(String userName) {
        view.showProgress();
        repository.getToken(userName).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::resultToken,this::resultError);

    }

    @Override
    public void sendLoginPresenter(String userName, String password, String token) {
        repository.loginUser(userName, password, token).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::resultLogin,this::resultError);
    }


    private void resultLogin(LoginUser loginUser) {
        view.hideProgress();
        view.navigateToContacts(loginUser.getSessionName());
    }

    private void resultError(Throwable throwable) {
        view.hideProgress();
        view.showError("Error :" + throwable.getMessage());
    }

    private void resultToken(Token token) {
        view.sendLogin(token);
    }

    
}
