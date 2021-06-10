package com.manuellugodev.datacrmappjava.framework.retrofit;

import com.manuellugodev.datacrmappjava.framework.retrofit.model.response.ChallegeResponse;
import com.manuellugodev.datacrmappjava.framework.retrofit.model.response.ContactsResponse;
import com.manuellugodev.datacrmappjava.framework.retrofit.model.response.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DataCrmApiService {

    @GET("webservice.php?operation=" + Constans.OP_GETCHALLENGE)
    Observable<ChallegeResponse> getChallenge(@Query("username") String userName);

    @POST("webservice.php?")
    @FormUrlEncoded
    Observable<LoginResponse> postLogin(
            @Field("operation") String operation,
            @Field("username") String userName,
            @Field("accessKey") String accessKey
    );

    @GET("webservice.php?operation="+ Constans.OP_QUERY + "&query=select * from Contacts;")
    Observable<ContactsResponse> getContacts(@Query("sessionName")String sessionName);
}
