package com.sheetal.amigo_thestudybuddy;

import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MainViewHolder extends RecyclerView.ViewHolder {
    public TextView txtName;
    public CardView cardView;
    public MainViewHolder(View itemView){
     super(itemView);

     txtName=itemView.findViewById(R.id.pdf_txtName);
     cardView=itemView.findViewById(R.id.pdf_cardView);

    }
}
