package com.sheetal.amigo_thestudybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

public class Login extends android.app.Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        getSupportActionBar().setTitle("Sign In");

        TextView textView = (TextView) findViewById(R.id.signUp);
        textView.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, SignUp.class);
            startActivity(intent);
        });

       Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent intent=new Intent(Login.this,HomeActivity.class);
            startActivity(intent);
        });

    }
}
