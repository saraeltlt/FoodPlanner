package com.example.foodplanner.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiClient instance = null;
    private Api myApi;
    String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private ApiClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL )
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        myApi = retrofit.create(Api.class);
    }

    public static synchronized ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    public Api getMyApi() {
        return myApi;
    }
}
