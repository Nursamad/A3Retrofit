package com.geektech.a3.data.remote;

import com.geektech.a3.data.models.Film;

import java.util.List;

public interface FilmsCallback {

    void success(List<Film> films);

    void failure(String msg);
}
