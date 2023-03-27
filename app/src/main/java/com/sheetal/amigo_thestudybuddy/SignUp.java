package com.sheetal.amigo_thestudybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SignUp extends android.app.Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

//        getSupportActionBar().setTitle("Sign UP");
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        TextView textView = (TextView) findViewById(R.id.signIn);
        textView.setOnClickListener(view -> {
            Intent intent = new Intent(SignUp.this, Login.class);
            startActivity(intent);
        });
    }

//    public boolean onSupportNavigateUp(){
//        onBackPressed();
//        return super.onSupportNavigateUp();
//    }
}