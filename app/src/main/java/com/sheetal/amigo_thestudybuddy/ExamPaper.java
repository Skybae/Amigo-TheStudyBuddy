package com.sheetal.amigo_thestudybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ExamPaper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_paper);

        getSupportActionBar().setTitle("PYQ");
    }
}