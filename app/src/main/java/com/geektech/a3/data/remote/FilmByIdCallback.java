package com.geektech.a3.data.remote;

import com.geektech.a3.data.models.Film;

public interface FilmByIdCallback {

    void successById(Film body);

    void failure(String localizedMessage);
}
