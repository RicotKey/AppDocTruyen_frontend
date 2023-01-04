package com.example.libs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static Retrofit retrofit2;
    private static String BASE_URL = "http://10.0.2.2:8080/";
    private static String BASE_URL_AUDIO = "https://api.fpt.ai/";
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public static Retrofit getRetrofitInstanceAudio() {
        if (retrofit2 == null) {
            retrofit2 = new Retrofit.Builder().baseUrl(BASE_URL_AUDIO).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit2;
    }
}
