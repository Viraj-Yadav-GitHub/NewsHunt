package com.example.newshunt.categoryFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.newshunt.AdapterClass;
import com.example.newshunt.Models.Articalclass;
import com.example.newshunt.Models.Modelclass;
import com.example.newshunt.R;
import com.example.newshunt.RetroFit.ApiUtiliti;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class technologyFragment extends Fragment {

    private RecyclerView rvTech;
    String api = "c38a4ea9f38744308ba0ea4b21cd0b90";
    ArrayList<Modelclass> modelclassArrayList;
    AdapterClass adapter;
    ProgressBar progressBar ;

    public technologyFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_technology, container, false);

        rvTech = view.findViewById(R.id.rvTech);
        modelclassArrayList = new ArrayList<>();
        rvTech.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AdapterClass(getContext(), modelclassArrayList);
        rvTech.setAdapter(adapter);
        progressBar = view.findViewById(R.id.pBar);
        progressBar.setVisibility(View.VISIBLE);


        findNews();

        return view ;
    }

    private void findNews() {

        ApiUtiliti.getApiInterface().getcategoryNews("in", "technology",100, api).enqueue(new Callback<Articalclass>() {
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