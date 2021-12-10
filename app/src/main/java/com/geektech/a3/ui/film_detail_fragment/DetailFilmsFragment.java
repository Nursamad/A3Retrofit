package com.geektech.a3.ui.film_detail_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geektech.a3.App;
import com.geektech.a3.R;
import com.geektech.a3.data.models.Film;
import com.geektech.a3.data.remote.FilmByIdCallback;
import com.geektech.a3.data.remote.FilmsCallback;
import com.geektech.a3.databinding.FragmentDetailFilmsBinding;
import com.geektech.a3.ui.films_fragment.FilmsAdapter;

import java.util.List;

public class DetailFilmsFragment extends Fragment {
    private FragmentDetailFilmsBinding binding;
    private DetailAdapter adapter2;

    public DetailFilmsFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailFilmsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        String id = getArguments().getString("key");
        App.client.getFilmById(new FilmByIdCallback() {
            @Override
            public void successById(Film film) {
                adapter2.setFilm(film);
            }

            @Override
            public void failure(String msg) {
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show();
            }
        }, id);

    }

    private void initViews() {
        adapter2 = new DetailAdapter();
        binding.recyclerDetail.setAdapter(adapter2);
    }

}