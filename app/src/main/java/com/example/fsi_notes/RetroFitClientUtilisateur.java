package com.example.fsi_notes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClientUtilisateur {
    private static RetroFitClientUtilisateur instance = null;
    private API_FSI myApi;
    private RetroFitClientUtilisateur(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_FSI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(API_FSI.class);
    }

    public static RetroFitClientUtilisateur getInstance(){
        if (instance == null){
            instance = new RetroFitClientUtilisateur();
        }
        return instance;
    }
    public API_FSI getMyApi(){
        return myApi;
    }

}