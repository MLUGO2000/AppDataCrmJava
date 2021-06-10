package com.manuellugodev.datacrmappjava.framework.sources;

import com.manuellugodev.datacrmappjava.data.sources.SourceLogin;
import com.manuellugodev.datacrmappjava.domain.login.LoginUser;
import com.manuellugodev.datacrmappjava.domain.login.Token;
import com.manuellugodev.datacrmappjava.framework.retrofit.DataCrmApiService;
import com.manuellugodev.datacrmappjava.framework.retrofit.model.TokenApi;

import com.manuellugodev.datacrmappjava.framework.retrofit.model.UserLoginApi;
import com.manuellugodev.datacrmappjava.framework.retrofit.model.response.ChallegeResponse;
import com.manuellugodev.datacrmappjava.framework.retrofit.model.response.LoginResponse;


import java.math.BigInteger;
import java.security.MessageDigest;

import io.reactivex.Observable;


public class LoginApiDataCrm implements SourceLogin {
    DataCrmApiService service;

    public LoginApiDataCrm(DataCrmApiService service){
        this.service=service;
    }

    @Override
    public Observable<Token> getTokenApi(String userName) {
       Observable<ChallegeResponse> response=service.getChallenge(userName);
       return response.map(reponseMap->reponseMap.getResultToken()).map(token->TokenApitoDomain(token));
    }

    @Override
    public Observable<LoginUser> sendLoginRequest(String userName, String password, String token) {
        String access=token+password;
        String accessKey=getMd5(access);
        Observable<LoginResponse> response=service.postLogin("login",userName,accessKey);

        return response.map(res->{
            if(res.getSuccess()){
                return loginApiToDomain(res.getResultLogin());
            }else {
                throw new Exception("Error: Code: "+ res.getError().getCodeError() + " message:" + res.getError().getMessage());
            }

        });


    }

    LoginUser loginApiToDomain(UserLoginApi loginApi){
        return new LoginUser(loginApi.getSessionName(),loginApi.getUserId(),loginApi.getVersion(),loginApi.getvTigerVersion());
    }

    Token TokenApitoDomain(TokenApi tokenApi){
        return new Token(tokenApi.getToken(),tokenApi.getServerTime(),tokenApi.getExpireTime());
    }

    private String getMd5(String key){
        try {

            MessageDigest md= MessageDigest.getInstance("MD5");

            byte[] thedigest =md.digest(key.getBytes());

            BigInteger no=new BigInteger(1,thedigest);

            String hashText=no.toString(16);

            while (hashText.length()<32){
                hashText = "0"+ hashText;
            }
            return hashText;

        }catch (Exception e){

            return "Error Funcion Hash";

        }

    }
}
