package com.sheetal.amigo_thestudybuddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private Context context;
    private List<File> pdfFiles;

    public MainAdapter(Context context, List<File> pdfFiles){
        this.context=context;
        this.pdfFiles=pdfFiles;
    }
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false));
    }
        public void onBindViewHolder(MainViewHolder holder, int position){
          holder.txtName.setText(pdfFiles.get(position).getName());
          holder.txtName.setSelected(true);
        }
        public int getItemCount(){
        return pdfFiles.size();
    }
}
