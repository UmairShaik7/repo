package com.retrofitlib.abc.retrofitsample;

import com.retrofitlib.abc.retrofitsample.pojo.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ABC on 02/11/2016.
 */

public interface RestaurantAPI {

    @Headers("user-key: 9b48f6666c779c167a90bfbb864ad66f")

    @GET("/api/v2.1/geocode")
    Call<List<Restaurant>> getTask(@Query("lat") double lat,
                                   @Query("lon") double lon);
}
