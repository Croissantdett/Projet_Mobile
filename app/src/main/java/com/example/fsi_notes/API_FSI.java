package com.example.fsi_notes;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API_FSI {

    String BASE_URL = "https://capyfsi.site/API/";

    @FormUrlEncoded
    @POST("Eloi.php")
    Call<Utilisateur> demon(
            @Field("login") String login,
            @Field("mdp") String mdp
    );
}
