package com.example.ejercicios3api23.adapter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainAdapter {
    Retrofit retrofit;

    public Retrofit getAdapter(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;


    }

}
