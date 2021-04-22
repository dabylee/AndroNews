package com.app.andronews.retrofitconfig;

public class RetrofitConfigToJson {

    public static String URL_API = "https://newsapi.org/";
        // v2/top-headlines?country=id&apiKey=4fed3a8d8ad049c88f1e4ceb3adaf91b"

    public static GetJsonAll getResponses(){

        return RetrofitInstance.getInstance(URL_API).create(GetJsonAll.class);

    }
}
