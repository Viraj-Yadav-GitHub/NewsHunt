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


public class businessFragment extends Fragment {

    private RecyclerView rvBusiness;
    String api = "d21f2d13972c4f4a92c1b846afeb416e";
    ArrayList<Modelclass> modelclassArrayList;
    AdapterClass adapter;
    ProgressBar progressBar ;

    public businessFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_business, container, false);

        rvBusiness = view.findViewById(R.id.rvBusiness);
        modelclassArrayList = new ArrayList<>();
        rvBusiness.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AdapterClass(getContext(), modelclassArrayList);
        rvBusiness.setAdapter(adapter);

        progressBar = view.findViewById(R.id.pBar);
        progressBar.setVisibility(View.VISIBLE);

        findNews();

        return view ;
    }

    private void findNews() {

        ApiUtiliti.getApiInterface().getcategoryNews("in", "business",100, api).enqueue(new Callback<Articalclass>() {
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