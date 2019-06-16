package com.example.smoot.movies3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<AlbumMovies>  arrayList = new ArrayList<>();

  //  String mDrawableName = "pic1";
  //  int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
   // String mDrawableName2 = "pic2";
   // int resID2 = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());

  //  int[] image_id= {resID,resID2};

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

        for (int id : image_id){
            Log.d( "id of images", id+"" );

            arrayList.add(new AlbumMovies(id));
        }
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);

    }
}
