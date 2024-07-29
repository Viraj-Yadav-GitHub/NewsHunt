package com.example.newshunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread td = new Thread(){

            @Override
            public void run() {
                try {

                    sleep(1000);

                }catch (Exception exception){

                    exception.printStackTrace();

                }finally {


                    SharedPreferences sharedPreferences = getSharedPreferences(login.PREFS_NAME , MODE_PRIVATE);
                    boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn" ,false);

                    Intent intent;
                    if(hasLoggedIn)
                    {
                        intent = new Intent(SplashScreen.this, MainActivity.class);
                    }else
                    {
                        intent = new Intent(SplashScreen.this, login.class);
                    }
                    startActivity(intent);
                    finish();


                }
            }
        };td.start();
    }
}