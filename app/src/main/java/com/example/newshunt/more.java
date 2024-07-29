package com.example.newshunt;



import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class more extends AppCompatActivity {


    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        getSupportActionBar().hide();


        ImageView backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });




        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new fragAdapter(getSupportFragmentManager()));

        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.sport);
        tabLayout.getTabAt(1).setIcon(R.drawable.health);
        tabLayout.getTabAt(2).setIcon(R.drawable.science);
        tabLayout.getTabAt(3).setIcon(R.drawable.entertainment);
        tabLayout.getTabAt(4).setIcon(R.drawable.politics);
        tabLayout.getTabAt(5).setIcon(R.drawable.business);
        tabLayout.getTabAt(6).setIcon(R.drawable.technology);




    }
}