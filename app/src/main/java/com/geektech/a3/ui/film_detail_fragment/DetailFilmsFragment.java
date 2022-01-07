package com.geektech.a3.ui.film_detail_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.geektech.a3.App;
import com.geektech.a3.data.models.Film;
import com.geektech.a3.data.remote.FilmByIdCallback;
import com.geektech.a3.databinding.FragmentDetailFilmsBinding;

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
        String id = null;
        if (getArguments() != null) {
            id = getArguments().getString("key");
        }
        App.client.getFilmById(new FilmByIdCallback() {
            @Override
            public void successById(Film film) {
//                adapter2.setFilm(film);
                setDataFilm(film);
            }

            @Override
            public void failure(String msg) {
                Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show();
            }
        }, id);

    }

    private void setDataFilm(Film film) {
        Glide
                .with(requireContext())
                .load(film.getMovieBanner())
                .into(binding.filmIv);
        binding.title.setText(film.getTitle());
        binding.origTitle.setText(film.getOriginalTitle());
        binding.director.setText(film.getDirector());
        binding.producer.setText(film.getProducer());
        binding.realiseData.setText(film.getReleaseDate());
        binding.description.setText(film.getDescription());
    }

    private void initViews() {
        adapter2 = new DetailAdapter();
//        binding.recyclerDetail.setAdapter(adapter2);
    }

}