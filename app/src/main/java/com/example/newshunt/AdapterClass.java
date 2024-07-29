package com.example.newshunt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newshunt.Models.Modelclass;


import java.util.ArrayList;
import java.util.Locale;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    Context context;
    ArrayList<Modelclass> modelclassArrayList;
    private ViewHolder holder;
    private int position;


    public AdapterClass(Context context, ArrayList<Modelclass> modelclassArrayList) {
        this.context = context;
        this.modelclassArrayList = modelclassArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.newscard , null , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, webView.class);
                intent.putExtra("url",modelclassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.time.setText("Time:- "+modelclassArrayList.get(position).getTime());
        holder.author.setText("By:- "+modelclassArrayList.get(position).getAuthor());
        holder.heading.setText(modelclassArrayList.get(position).getTitle());
        holder.desc.setText(modelclassArrayList.get(position).getDescription());
        Glide.with(context).load(modelclassArrayList.get(position).getUrltoimg()).into(holder.imageView);






    }

    @Override
    public int getItemCount() {
        return modelclassArrayList.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

      TextView heading ,desc , author , time ;
      ImageView imageView;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            heading = itemView.findViewById(R.id.heading);
            desc = itemView.findViewById(R.id.description);
            author = itemView.findViewById(R.id.Author);
            time = itemView.findViewById(R.id.time);
            imageView = itemView.findViewById(R.id.img);


        }
    }



}
