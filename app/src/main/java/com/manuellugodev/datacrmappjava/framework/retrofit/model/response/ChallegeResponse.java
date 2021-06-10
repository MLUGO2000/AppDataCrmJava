package com.manuellugodev.datacrmappjava.framework.retrofit.model.response;

import com.google.gson.annotations.SerializedName;
import com.manuellugodev.datacrmappjava.framework.retrofit.model.TokenApi;

public class ChallegeResponse {

    public ChallegeResponse(Boolean success, TokenApi resultToken, ErrorApi error) {
        this.success = success;
        this.resultToken = resultToken;
        this.error = error;
    }

    @SerializedName("success")
    private Boolean success;
    @SerializedName("result")
    private TokenApi resultToken;
    @SerializedName("error")
    private ErrorApi error;

    public Boolean getSuccess() {
        return success;
    }

    public TokenApi getResultToken() {
        return resultToken;
    }

    public ErrorApi getError() {
        return error;
    }
}
