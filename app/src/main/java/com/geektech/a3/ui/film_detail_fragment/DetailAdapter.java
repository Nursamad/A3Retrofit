package com.geektech.a3.ui.film_detail_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.a3.data.models.Film;
import com.geektech.a3.databinding.FragmentDetailFilmsBinding;
import com.geektech.a3.databinding.ItemDetailBinding;
import com.geektech.a3.databinding.ItemFilmBinding;
import com.geektech.a3.ui.films_fragment.FilmsAdapter;

import java.util.ArrayList;
import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {

    private List<Film> films = new ArrayList<>();
    private FragmentDetailFilmsBinding binding;

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDetailBinding binding = ItemDetailBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DetailAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public void setFilm(Film film) {
        films.add(0,film);
        notifyItemInserted(0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemDetailBinding binding;

        public ViewHolder(@NonNull ItemDetailBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Film film) {
            binding.title.setText(film.getTitle());
            binding.origTitle.setText(film.getOriginalTitle());
            binding.director.setText(film.getDirector());
            binding.producer.setText(film.getProducer());
            binding.realiseData.setText(film.getReleaseDate());
            binding.description.setText(film.getDescription());
        }
    }
}
