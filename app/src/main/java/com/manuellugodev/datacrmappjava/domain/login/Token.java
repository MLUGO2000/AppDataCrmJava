package com.manuellugodev.datacrmappjava.domain.login;

public class Token {
    private String token;
    private Long serverTime;
    private Long expireTime;

    public Token(String token, Long serverTime, Long expireTime) {
        this.token = token;
        this.serverTime = serverTime;
        this.expireTime = expireTime;
    }

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
