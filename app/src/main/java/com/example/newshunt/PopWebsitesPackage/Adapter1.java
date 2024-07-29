package com.example.newshunt.PopWebsitesPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newshunt.R;

import java.util.ArrayList;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.viewHolder>{

    ArrayList<Model1> list ;
    Context context ;

    public Adapter1(ArrayList<Model1> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.popnewscard , parent ,false);
        return new viewHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Model1 adapter1 = list.get(position);
        holder.imageView.setImageResource(adapter1.getPic());
        holder.textView.setText(adapter1.getText());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageView ;
        TextView textView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ivPopWeb);
            textView = itemView.findViewById(R.id.tvpopweb);

        }
    }

}
