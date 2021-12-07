package com.geektech.a3;

import android.app.Application;

import com.geektech.a3.data.remote.FilmsApi;
import com.geektech.a3.data.remote.FilmsApiClient;
import com.geektech.a3.data.remote.RetrofitClient;

public class App extends Application {

    private RetrofitClient retrofitClient;

    public static FilmsApi api;
    public static FilmsApiClient client;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideFilmsApi();
        client = new FilmsApiClient();
    }
}
