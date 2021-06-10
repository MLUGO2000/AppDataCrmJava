package com.manuellugodev.datacrmappjava.presentation.ui.login;


import com.manuellugodev.datacrmappjava.domain.login.Token;

public interface LoginContracts {

    interface view{
        void navigateToContacts(String userSessionName);
        void showError(String error);
        void sendLogin(Token token);
        void showProgress();
        void hideProgress();
    }

    interface presenter{
        void sendRequestToken(String userName);
        void sendLoginPresenter(String userName,String password,String token);
    }


}
