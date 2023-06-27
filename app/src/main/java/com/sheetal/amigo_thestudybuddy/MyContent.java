package com.sheetal.amigo_thestudybuddy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MyContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_content);

        getSupportActionBar().setTitle("My Content");

    }
}