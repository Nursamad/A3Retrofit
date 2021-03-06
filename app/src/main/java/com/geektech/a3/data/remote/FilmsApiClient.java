package com.geektech.a3.data.remote;

import com.geektech.a3.App;
import com.geektech.a3.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsApiClient {

    public void getFilms(FilmsCallback filmsCallback) {
        App.api.getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    filmsCallback.success(response.body());
                } else {
                    filmsCallback.failure(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                filmsCallback.failure(t.getLocalizedMessage());
            }
        });
    }

    public void getFilmById(FilmByIdCallback filmByIdCallback, String id) {
        App.api.getFilmById(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                filmByIdCallback.successById(response.body());
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                filmByIdCallback.failure(t.getLocalizedMessage());
            }
        });
    }

}
