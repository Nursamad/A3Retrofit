package com.geektech.a3.ui.films_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.a3.App;
import com.geektech.a3.R;
import com.geektech.a3.data.models.Film;
import com.geektech.a3.data.remote.FilmsCallback;
import com.geektech.a3.databinding.FragmentFilmsBinding;
import com.geektech.a3.interfaces.OnItemClickListener;

import java.util.List;

public class FilmsFragment extends Fragment implements OnItemClickListener {

    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    public FilmsFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FilmsAdapter();
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
        adapter.setOnItemClickListener(this);

        App.client.getFilms(new FilmsCallback() {
            @Override
            public void success(List<Film> films) {
                adapter.setFilms(films);
            }

            @Override
            public void failure(String msg) {
                Log.e("TAG", "failure: " + msg);
            }
        });
        initViews();
    }

    private void initViews() {
        binding.filmsRecycler.setAdapter(adapter);
    }

    private void openFragment(String id) {
        Bundle bundle = new Bundle();
        bundle.putString("key", id);
        NavController navController = Navigation.findNavController(requireActivity(), R.id.navHost);
        navController.navigate(R.id.detailFilmsFragment, bundle);
    }

    @Override
    public void onClick(int position) {
        Film film = adapter.getItem(position);
        openFragment(film.getId());
    }
}