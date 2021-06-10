package com.manuellugodev.datacrmappjava.framework.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class UserLoginApi {
    public UserLoginApi(){}

    @SerializedName("sessionName")
    private String sessionName;
    @SerializedName("userId")
    private String userId;
    @SerializedName("version")
    private String version;
    @SerializedName("vtigerVersion")
    private String vTigerVersion;

    public String getSessionName() {
        return sessionName;
    }

    public String getUserId() {
        return userId;
    }

    public String getVersion() {
        return version;
    }

    public String getvTigerVersion() {
        return vTigerVersion;
    }
}
