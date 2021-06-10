package com.manuellugodev.datacrmappjava.domain.login;

public class LoginUser {
    private String sessionName;
    private String userId;
    private String version;
    private String vTigerVersion;

    public LoginUser(String sessionName, String userId, String version, String vTigerVersion) {
        this.sessionName = sessionName;
        this.userId = userId;
        this.version = version;
        this.vTigerVersion = vTigerVersion;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getvTigerVersion() {
        return vTigerVersion;
    }

    public void setvTigerVersion(String vTigerVersion) {
        this.vTigerVersion = vTigerVersion;
    }
}
