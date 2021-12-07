package com.geektech.a3.ui.films_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geektech.a3.App;
import com.geektech.a3.R;
import com.geektech.a3.data.models.Film;
import com.geektech.a3.data.remote.FilmsCallback;
import com.geektech.a3.databinding.FragmentFilmsBinding;

import java.util.List;

public class FilmsFragment extends Fragment {

    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    private FilmsFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new FilmsAdapter();
        binding.filmsRecycler.setAdapter(adapter);

        App.client.getFilms(new FilmsCallback() {
            @Override
            public void success(List<Film> films) {
                adapter.setFilms(films);
            }

            @Override
            public void failure(String msg) {
                Log.e("TAG", "failure: " + msg );
            }
        });
    }
}