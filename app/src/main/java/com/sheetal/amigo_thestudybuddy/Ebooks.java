package com.sheetal.amigo_thestudybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Ebooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebooks);

        getSupportActionBar().setTitle("E-books");
    }
}