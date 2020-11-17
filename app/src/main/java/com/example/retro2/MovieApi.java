package com.example.retro2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    //https://run.mocky.io/v3/c38ef967-0c43-4cbb-b4a0-1f330e2d33b7    //Parsing JSON using Retrofit
    //https://run.mocky.io/v3/8205ce05-5ac2-4801-8afd-0f190f4f136c    // Parsing JSON from Array using Retrofit
    @GET("8205ce05-5ac2-4801-8afd-0f190f4f136c ")
    Call<JSONResponse> getMovies();


}
