package com.example.news_app_youtube;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {
    public Adapter(Context context, ArrayList<ModelClass> modelClassesArrayList) {
        this.context = context;
        this.modelClassesArrayList = modelClassesArrayList;
    }

    Context context;
            ArrayList<ModelClass> modelClassesArrayList;
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, webviewfor.class);
                intent.putExtra("url",modelClassesArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.mtime.setText("Published At:-"+ modelClassesArrayList.get(position).getPublishedAt());
        holder.mauthor.setText(modelClassesArrayList.get(position).getAuthor());
        holder.mheading.setText(modelClassesArrayList.get(position).getTitle());
        holder.mcontent.setText(modelClassesArrayList.get(position).getDescription());
        Glide.with(context).load(modelClassesArrayList.get(position).getUrlToImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return modelClassesArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView mheading,mcontent,mauthor,mcategory,mtime;
        ImageView imageView;
        CardView cardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            mheading=itemView.findViewById(R.id.mainheading);
            mcontent=itemView.findViewById(R.id.content);
            mauthor=itemView.findViewById(R.id.author);
//            mcategory=itemView.findViewById(R.id.mainhead);
            imageView=itemView.findViewById(R.id.imageview);
            cardView=itemView.findViewById(R.id.cardview);
            mtime=itemView.findViewById(R.id.time);
        }
    }
}
