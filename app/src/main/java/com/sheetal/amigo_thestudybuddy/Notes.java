package com.sheetal.amigo_thestudybuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;

public class Notes extends AppCompatActivity {
    CardView cardView;
    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        getSupportActionBar().setTitle("Notes");

//        pdfView = findViewById(R.id.pdfView);

//        cardView = findViewById(R.id.unit1);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openPdfActivity("Unit 1.pdf");
//            }
//        });
//
//        cardView=findViewById(R.id.unit2);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openPdfActivity("U");
//            }
//        });
//        cardView=findViewById(R.id.unit3);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openPdfActivity("Unit 3.pptx");
//            }
//        });
//        cardView=findViewById(R.id.unit4);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openPdfActivity("Unit 4.pptx");
//            }
//        });
    }
    private void openPdfActivity(String selectedPdf) {
        Intent intent = new Intent(getApplicationContext(), DocumentActivity.class);
        intent.putExtra("pdfFileName", selectedPdf);
        startActivity(intent);
    }
}