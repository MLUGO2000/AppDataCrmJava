package com.manuellugodev.datacrmappjava.framework.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class TokenApi {
    public TokenApi(){}
    @SerializedName("token")
    private String token;
    @SerializedName("serverTime")
    private Long serverTime;
    @SerializedName("expireTime")
    private Long expireTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getServerTime() {
        return serverTime;
    }

    public void setServerTime(Long serverTime) {
        this.serverTime = serverTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
}
