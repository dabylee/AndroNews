package com.app.andronews.retrofitconfig;

import com.app.andronews.retrofitjson.NewsList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetJsonAll {


    @GET("v2/top-headlines")
    Call<NewsList> getNewslistCategory(

        @Query("country")
        String country,

        @Query("category")
        String category,

        @Query("apiKey")
        String apilkey


    );

    @GET("v2/top-headlines")
    Call<NewsList> getNewsList(

        @Query("country")
        String country,

        @Query("apiKey")
        String apilkey
    );




}
