package com.kodelabs.boilerplate.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hyuchiha on 15/05/17.
 */

public class ServiceGenerator {
    private Retrofit retrofit;
    private  final static String BASE_URL = "http://taxis.geoint.mx:5072/api/";
    //private  final static String BASE_URL = "http://192.168.0.7:4000/api/v1/";

    /**
     * Constructor base del Cliente
     */
    public ServiceGenerator() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
