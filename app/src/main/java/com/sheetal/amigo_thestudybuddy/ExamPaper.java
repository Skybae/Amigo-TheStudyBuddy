package com.sheetal.amigo_thestudybuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.IOException;
import java.io.InputStream;

public class ExamPaper extends AppCompatActivity {

    CardView cardView;
    private PDFView pdfView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_paper);

        getSupportActionBar().setTitle("PYQ");

        pdfView = findViewById(R.id.pdfView);

        cardView = findViewById(R.id.summer22);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdfActivity("Summer 22.pdf");
            }
        });

        cardView=findViewById(R.id.winter22);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdfActivity("Winter 22.pdf");
            }
        });
        cardView=findViewById(R.id.winter21);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdfActivity("Winter 21.pdf");
            }
        });
    }



    private void openPdfActivity(String selectedPdf) {
        Intent intent = new Intent(getApplicationContext(), DocumentActivity.class);
        intent.putExtra("pdfFileName", selectedPdf);
        startActivity(intent);
    }

}