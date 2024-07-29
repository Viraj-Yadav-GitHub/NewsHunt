package com.example.newshunt.SearchNews;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.newshunt.Models.Articalclass;
import com.example.newshunt.Models.Modelclass;
import com.example.newshunt.R;
import com.example.newshunt.RetroFit.ApiUtiliti;


import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String api = "81d678c1e21147fd8e4c0ca7db19cd69";
    ArrayList<Modelclass> searchModels;
    AdapterSearch adapter;
    String country = "in";
    EditText editText ;
    ProgressBar progressBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.searchRV);
        editText = findViewById(R.id.edtSearch);

        progressBar = findViewById(R.id.pBarx);
        progressBar.setVisibility(View.VISIBLE);

        searchModels = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterSearch(this, searchModels);
        recyclerView.setAdapter(adapter);

        ImageView backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        findNews();


    }

    private void findNews() {


        ApiUtiliti.getApiInterface().getNews(country, 100, api).enqueue(new Callback<Articalclass>() {
            @Override
            public void onResponse(Call<Articalclass> call,  Response<Articalclass> response) {

                if (response.isSuccessful()) {

                    progressBar.setVisibility(View.GONE);
                    searchModels.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<Articalclass> call, Throwable t) {
            }
        });


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                filter(editable.toString());
            }
        });

    }

    private void filter(String text) {

        ArrayList<Modelclass> filterList = new ArrayList<>();
        for (Modelclass items : searchModels )
        {
            if(items.getTitle().toLowerCase().contains(text.toLowerCase()))
            {
                filterList.add(items);

            }
        }

        adapter.filterList(filterList);


    }

}