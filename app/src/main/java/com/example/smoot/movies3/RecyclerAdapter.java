package com.example.smoot.movies3;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    ArrayList<AlbumMovies> arrayList = new ArrayList<>();
    OnNoteListener mOnNoteListener;

    public RecyclerAdapter(ArrayList<AlbumMovies> m, OnNoteListener onNoteListener) {
        this.arrayList = m;
        this.mOnNoteListener = onNoteListener;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);

        return new MyViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).getImage_id());
    }

    @Override
    public int getItemCount() {
        return arrayList.size()-1;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        private OnNoteListener mOnNoteListener;
        CardView cardView = (CardView)itemView.findViewById(R.id.cardView);

        public MyViewHolder( View itemView, OnNoteListener mOnNoteListener) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.album_movies);
            this.mOnNoteListener = mOnNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: " + getAdapterPosition());
            mOnNoteListener.onNoteClick(getAdapterPosition());
        //   ((MainActivity) context).handleRecyclerClick(getData().get(getLayoutPosition()).getId());

        }
    }
    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
