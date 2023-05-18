package com.sheetal.amigo_thestudybuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ContentActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

                getSupportActionBar().setTitle("WebProgramming");

        CardView cv;
        cv= findViewById(R.id.cardSyllabus);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), Syllabus.class);
                startActivity(intent);
            }
        });
        cv= findViewById(R.id.cardExamPaper);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), ExamPaper.class);
                startActivity(intent);
            }
        });

        cv= findViewById(R.id.cardNotes);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), Notes.class);
                startActivity(intent);
            }
        });

        cv= findViewById(R.id.cardIMP);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), IMPquestions.class);
                startActivity(intent);
            }
        });
        cv= findViewById(R.id.cardEbooks);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), Ebooks.class);
                startActivity(intent);
            }
        });

        cv= findViewById(R.id.cardFlashCards);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), FlashCardActivity.class);
                startActivity(intent);
            }
        });
    }
    }
