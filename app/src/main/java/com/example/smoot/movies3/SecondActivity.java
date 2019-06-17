package com.example.smoot.movies3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

     //   Intent intent = getIntent();
        Bundle bundle = getIntent().getExtras();
        ImageView img = (ImageView) findViewById(R.id.photo);
        int id_ = bundle.getInt("photo", 0);
        img.setImageResource(id_);
    }
    /*
    Intent intent = getIntent();
    Bundle bundle = getIntent().getExtras();
    ImageView img = (ImageView) findViewById(R.id.photo);
    int id_ = bundle.getIntExtra("photo", 0);
    img.setImageResource(id_);*/



}
