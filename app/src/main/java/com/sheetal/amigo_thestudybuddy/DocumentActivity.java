package com.sheetal.amigo_thestudybuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class DocumentActivity extends AppCompatActivity {

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);

        pdfView = findViewById(R.id.pdfView);

        String pdfFileName = getIntent().getStringExtra("pdfFileName");
        getSupportActionBar().setTitle(pdfFileName);
        if (pdfFileName != null) {
            loadPDFFromAsset(pdfFileName);
        }

    }
    private void loadPDFFromAsset(String fileName) {
        try {
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open(fileName);
            pdfView.fromStream(inputStream).defaultPage(0).onPageChange(new OnPageChangeListener() {
                @Override
                public void onPageChanged(int page, int pageCount) {

                }
            }).onLoad(new OnLoadCompleteListener() {
                @Override
                public void loadComplete(int nbPages) {

                }
            }).scrollHandle(new DefaultScrollHandle(getApplicationContext())).spacing(10).load();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error opening PDF file", Toast.LENGTH_SHORT).show();
        }
    }




}