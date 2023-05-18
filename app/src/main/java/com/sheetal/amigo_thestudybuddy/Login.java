package com.sheetal.amigo_thestudybuddy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends android.app.Activity {

    EditText edUsername, edPassword;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        getSupportActionBar().setTitle("Sign In");
          edUsername= findViewById(R.id.editTextLoginUsername);
          edPassword=findViewById(R.id.editTextLoginPassword);
        TextView textView =  findViewById(R.id.signUp);
        textView.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, SignUp.class);
            Login.this.startActivity(intent);
        });

       Button button = findViewById(R.id.btn);
        button.setOnClickListener(v -> {
            String username =edUsername.getText().toString();
            String password= edPassword.getText().toString();
            Database db=new Database(getApplicationContext(), "Amigo SignUp Details",null,1);
            if(username.length()==0 || password.length()==0){
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show();
            }else {
                if (db.login(username, password) == 1) {
                    Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    //to save our data with key and value.
                    editor.apply();
                    Intent intent = new Intent(Login.this, HomeActivity .class);
                    startActivity(intent);
//                    getSupportActionBar().setTitle("Select Branch");

                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
