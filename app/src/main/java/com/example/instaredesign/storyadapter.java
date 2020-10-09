package com.example.instaredesign;



import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class storyadapter extends RecyclerView.Adapter<storyadapter.MyViewHolder> {
    private  Context context;
    private List<String> storylist;


    public storyadapter( Context context,  List<String> storylist){
        this.context=context;
        this.storylist=storylist;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater= LayoutInflater.from(context);
        View view=mInflater.inflate(R.layout.storylayout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull storyadapter.MyViewHolder holder, final int position) {
        int id = context.getResources().getIdentifier(storylist.get(position), "drawable", context.getPackageName());
            holder.imgThumbnail.setImageResource(id);

    }

    @Override
    public int getItemCount() {
        return 11;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgThumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);

            imgThumbnail=itemView.findViewById(R.id.storyimg);


        }
    }
}
