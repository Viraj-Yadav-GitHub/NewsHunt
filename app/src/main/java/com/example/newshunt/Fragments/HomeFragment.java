package com.example.newshunt.Fragments;


import android.content.Intent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.newshunt.AdapterClass;
import com.example.newshunt.Models.Articalclass;
import com.example.newshunt.Models.Modelclass;
import com.example.newshunt.R;

import com.example.newshunt.RetroFit.ApiUtiliti;
import com.example.newshunt.SearchNews.SearchActivity;
import com.example.newshunt.moreSettings;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {


    ImageView  live , more , searchimg ;
    ProgressBar progressBar ;








//    d21f2d13972c4f4a92c1b846afeb416e
    private RecyclerView recyclerView;
    String api = "d21f2d13972c4f4a92c1b846afeb416e";
    ArrayList<Modelclass> modelclassArrayList;
    AdapterClass adapter;
    String country = "in";

    


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);





     live= view.findViewById(R.id.live);
     recyclerView = view.findViewById(R.id.homeRv);
     progressBar = view.findViewById(R.id.pBar);
     progressBar.setVisibility(View.VISIBLE);
     more = view.findViewById(R.id.more);
        searchimg = view.findViewById(R.id.search_img);





        searchimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent i = new Intent(getContext() , SearchActivity.class);
              startActivity(i);
            }
        });



     more.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(getActivity() , moreSettings.class);
             startActivity(intent);
         }
     });


     live.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(getActivity() , com.example.newshunt.live.class);
             startActivity(intent);
         }
     });





        recyclerView = view.findViewById(R.id.homeRv);
        modelclassArrayList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AdapterClass(getContext(), modelclassArrayList);
        recyclerView.setAdapter(adapter);



        findNews();





        return view ;
    }



    private void findNews() {

        ApiUtiliti.getApiInterface().getNews(country, 100, api).enqueue(new Callback<Articalclass>() {
            @Override
            public void onResponse(Call<Articalclass> call, Response<Articalclass> response) {

                if (response.isSuccessful()) {

                    progressBar.setVisibility(View.GONE);
                    modelclassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<Articalclass> call, Throwable t) {

            }
        });

    }






}











