package com.sheetal.amigo_thestudybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends android.app.Activity {

    EditText edUsername, edEmail, edPassword,edPhone, edConfirm;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edUsername= findViewById(R.id.editTextRegUsername);
        edPhone= findViewById(R.id.editTextRegPhone);
        edPassword= findViewById(R.id.editTextRegPassword);
        edConfirm= findViewById(R.id.editTextRegConfirmPassword);
        edEmail=findViewById(R.id.editTextRegEmail);
        btn = findViewById(R.id.buttonSignUp);

//        getSupportActionBar().setTitle("Sign UP");
//
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        TextView textView = (TextView) findViewById(R.id.signIn);
        textView.setOnClickListener(view -> {
            Intent intent = new Intent(SignUp.this, Login.class);
            startActivity(intent);
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=edUsername.getText().toString();
                String email= edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db=new Database(getApplicationContext(), "Amigo SignUp Details",null, 1);
                if(username.length()==0 || email.length()==0 || password.length()==0 || confirm.length()==0){
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.compareTo(confirm)==0){
                        if(isValid(password)) {
                            db.signUp(username,email, password);
                            Toast.makeText(getApplicationContext(), "SignUp Sucessful", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(SignUp.this, Login.class);
                            startActivity(intent);
                        }

                        else{
                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters, having letter, digit and special symbol", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Password and Confirm password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public static boolean isValid(String passwordhere){
        int f1=0, f2=0, f3=0;
        if(passwordhere.length()<8){
            return false;
        }else{
            for(int p=0; p<passwordhere.length(); p++){
                if(Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for(int r=0; r<passwordhere.length();r++){
                if(Character.isLetter(passwordhere.charAt(r))){
                    f2=1;
                }
            }
            for(int s=0; s<passwordhere.length(); s++){
                char c=passwordhere.charAt(s);
                if(c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if(f1==1&& f2==1 && f3==1)
                return true;
            return false;
        }
    }

//    public boolean onSupportNavigateUp(){
//        onBackPressed();
//        return super.onSupportNavigateUp();
//    }
}