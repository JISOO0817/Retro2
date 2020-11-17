package com.example.retro2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //https://run.mocky.io/v3/b0b08dd4-9086-4e05-bb01-a2344545369f


    // Fixed Part of url;

    RecyclerView recyclerView;
    List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        movieList = new ArrayList<>();






        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieApi movieApi = retrofit.create(MovieApi.class);




        Call<JSONResponse> call = movieApi.getMovies();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                movieList = new ArrayList<>(Arrays.asList(jsonResponse.getMoviz()));

                PutDataIntoRecyclerView(movieList);

            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });


    }

    private void PutDataIntoRecyclerView(List<Movie> movieList) {

        MovieAdpater movieAdpater = new MovieAdpater(this,movieList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(movieAdpater);
    }
}