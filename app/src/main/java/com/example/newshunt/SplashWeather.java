package com.example.newshunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.newshunt.Weather.weatherActi;


public class SplashWeather extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_weather);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td = new Thread(){

            @Override
            public void run() {
                try {


                    sleep(2700);

                }catch (Exception exception){

                    exception.printStackTrace();

                }finally {

                    Intent intent = new Intent(SplashWeather.this , weatherActi.class);
                    startActivity(intent);
                    finish();

                }
            }
        };td.start();
    }
}