package com.universecodes.trackercovid19.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    public static Retrofit getRetrofitService() {
        return new Retrofit.Builder()
                .baseUrl(Api.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Retrofit getIndRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_IDN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Retrofit getRetrofitServiceNews(){
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL_NEWS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
