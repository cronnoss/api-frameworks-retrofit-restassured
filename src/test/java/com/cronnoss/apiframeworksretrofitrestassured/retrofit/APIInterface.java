package com.cronnoss.apiframeworksretrofitrestassured.retrofit;

import com.cronnoss.apiframeworksretrofitrestassured.pojo.CreateUserRequest;
import com.cronnoss.apiframeworksretrofitrestassured.pojo.CreateUserResponse;
import com.cronnoss.apiframeworksretrofitrestassured.pojo.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    @GET("users/2")
    Call<User> getUser();

    @POST("users")
    Call<CreateUserResponse> createUser(@Body CreateUserRequest body);
}
