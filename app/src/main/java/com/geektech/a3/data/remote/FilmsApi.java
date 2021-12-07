package com.geektech.a3.data.remote;

import com.geektech.a3.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FilmsApi {

    @GET("/films")
    Call<List<Film>> getFilms();
}
