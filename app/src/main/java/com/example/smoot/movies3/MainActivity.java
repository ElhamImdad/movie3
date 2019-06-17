package com.example.smoot.movies3;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.OnNoteListener {

    RecyclerView recyclerView ;
    RecyclerAdapter recyclerAdapter;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<AlbumMovies>  arrayList = new ArrayList<>();
/*
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
*/
    int[] image_id= {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
           R.drawable.pic6, R.drawable.pic7,R.drawable.pic8, R.drawable.pic9,R.drawable.pic10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
     //   imRecyclerView();
        for (int id : image_id){
            Log.d( "id of images", id+"" );

            arrayList.add(new AlbumMovies(id));
        }
        adapter = new RecyclerAdapter(arrayList, this);
        recyclerView.setAdapter(adapter);

   /*     RecyclerView click_img = (RecyclerView) findViewById(R.id.recyclerView);
        click_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        }); */
    }
/*
    private void imRecyclerView(){
        recyclerAdapter = new RecyclerAdapter(arrayList, this);
        recyclerView.setAdapter(recyclerAdapter);
    }*/
/*
    public void openActivity2() {
        TextView textView2 = (TextView)findViewById(R.id.texeView2);
        Intent intent = new Intent(this, SecondActivity.class);
      //  intent.putExtra(recyclerView, textView2);
        startActivity(intent);
    }*/
/*
    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }*/


    @Override
    public void onNoteClick(int position) {
        AlbumMovies albumMovies = arrayList.get(position);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("photo", albumMovies.getImage_id());
        startActivity(intent);
    }

}
