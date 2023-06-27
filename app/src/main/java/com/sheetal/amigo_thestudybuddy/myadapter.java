package com.sheetal.amigo_thestudybuddy;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options){
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myadapter.myviewholder holder, int position, @NonNull model model) {
        holder.txtView.setText(model.getFilename());
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.cardView.getContext(), viewpdf.class);
            intent.putExtra("filename", model.getFilename());
            intent.putExtra("fileurl", model.getFileurl());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            holder.cardView.getContext().startActivity(intent);

        });
    }

    @NonNull
    @Override
    public myadapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);

        return new myviewholder(view);
    }
    public static class myviewholder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView txtView;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cardview);
            txtView=itemView.findViewById(R.id.txtview);
        }
    }
}
