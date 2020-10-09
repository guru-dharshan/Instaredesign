package com.example.instaredesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



    public class postadapter extends RecyclerView.Adapter<postadapter.MyViewHolder> {
        private Context context;
        private List<String> postlist;


        public postadapter( Context context,  List<String> postlist){
            this.context=context;
            this.postlist=postlist;
        }




        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater mInflater= LayoutInflater.from(context);
            View view=mInflater.inflate(R.layout.postlayout,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            int id = context.getResources().getIdentifier(postlist.get(position), "drawable", context.getPackageName());
            holder.imgThumbnail.setImageResource(id);
        }



        @Override
        public int getItemCount() {
            return 9;
        }
        public static class MyViewHolder extends RecyclerView.ViewHolder{

            ImageView imgThumbnail;

            public MyViewHolder(View itemView) {
                super(itemView);

                imgThumbnail=itemView.findViewById(R.id.postimage);


            }
        }
    }


