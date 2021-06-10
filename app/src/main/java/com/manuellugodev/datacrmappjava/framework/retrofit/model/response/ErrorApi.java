package com.manuellugodev.datacrmappjava.framework.retrofit.model.response;

import com.google.gson.annotations.SerializedName;

public class ErrorApi {
    public ErrorApi(){}
    @SerializedName("code")
    private String codeError;
    @SerializedName("message")
    private String message;

    public String getCodeError() {
        return codeError;
    }

    public String getMessage() {
        return message;
    }
}
