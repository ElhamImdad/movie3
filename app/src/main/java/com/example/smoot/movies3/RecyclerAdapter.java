package com.example.smoot.movies3;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    ArrayList<AlbumMovies> arrayList = new ArrayList<>();

    public RecyclerAdapter(ArrayList<AlbumMovies> m) {
        this.arrayList = m;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).getImage_id());
    }

    @Override
    public int getItemCount() {
        return arrayList.size()-1;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        CardView cardView = (CardView)itemView.findViewById(R.id.cardView);
        public MyViewHolder( View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.album_movies);
        }
    }
}
