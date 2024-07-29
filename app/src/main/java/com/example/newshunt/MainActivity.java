package com.example.newshunt;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newshunt.Fragments.HomeFragment;
import com.example.newshunt.Fragments.NewspaperFragment;
import com.example.newshunt.Fragments.worldnewsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        FrameLayout frameLayout = findViewById(R.id.frameLayout);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnav);

        getSupportActionBar().hide();

        CheckConnection();



        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new HomeFragment());
        fragmentTransaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {

                    case R.id.home:

                        fragmentTransaction.replace(R.id.frameLayout, new HomeFragment());

                        break;
                    case R.id.newspaper:
                        fragmentTransaction.replace(R.id.frameLayout, new NewspaperFragment());
                        break;
                    case R.id.weather:
                        Intent i = new Intent(MainActivity.this , SplashWeather.class);
                        startActivity(i);
                        break;
                    case R.id.worldnews:
                        fragmentTransaction.replace(R.id.frameLayout, new worldnewsFragment());
                        break;
                    case R.id.more:
                        Intent intent = new Intent(MainActivity.this , more.class);
                        startActivity(intent);


                        break;
                    default:

                }
                fragmentTransaction.commit();
                return true;
            }
        });






    }


    public void CheckConnection(){

        ConnectivityManager manager  = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
        if(null != activeNetwork){

            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI){

            }
            else  if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE){

            }

        }
        else{


            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this );
        builder.setTitle("EXIT !!");
        builder.setMessage("Are you sure want to Exit ??").setCancelable(false).
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.super.onBackPressed();
                        finishAffinity();


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

}