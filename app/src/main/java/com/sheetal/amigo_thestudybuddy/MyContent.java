package com.sheetal.amigo_thestudybuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;

public class MyContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_content);

        getSupportActionBar().setTitle("My Content");
        onBackPressed();

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MyContent.this,HomeActivity.class));

        super.onBackPressed();
    }
}