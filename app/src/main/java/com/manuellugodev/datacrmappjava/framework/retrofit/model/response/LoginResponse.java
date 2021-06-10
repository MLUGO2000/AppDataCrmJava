package com.manuellugodev.datacrmappjava.framework.retrofit.model.response;

import com.google.gson.annotations.SerializedName;
import com.manuellugodev.datacrmappjava.framework.retrofit.model.UserLoginApi;

public class LoginResponse {

    public LoginResponse(Boolean success, UserLoginApi resultLogin, ErrorApi error) {
        this.success = success;
        this.resultLogin = resultLogin;
        this.error = error;
    }

    @SerializedName("success")
    private Boolean success;
    @SerializedName("result")
    private UserLoginApi resultLogin;
    @SerializedName("error")
    private ErrorApi error;

    public Boolean getSuccess() {
        return success;
    }

    public UserLoginApi getResultLogin() {
        return resultLogin;
    }

    public ErrorApi getError() {
        return error;
    }
}
