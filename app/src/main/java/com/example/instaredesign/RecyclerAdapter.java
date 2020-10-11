package com.example.instaredesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.ArrayList;
import java.util.List;

 class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    List<String> posts=new ArrayList<>();
    Context context;

    public RecyclerAdapter(List<String> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.postcards,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.postsimages.setImageResource(posts.get(position));
        int id = context.getResources().getIdentifier(posts.get(position), "drawable", context.getPackageName());
        Glide.with(context).load(id).centerCrop().into(holder.postsimages);
        holder.likedphoto.setImageResource(R.drawable.groupdark);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView postsimages,likedphoto;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            postsimages=itemView.findViewById(R.id.imageposts);
            likedphoto=itemView.findViewById(R.id.likedphoto);
        }
    }
}

