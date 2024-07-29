package com.example.newshunt;

import static com.example.newshunt.login.PREFS_NAME;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class moreSettings extends AppCompatActivity {

    TextView rate , share , about , contact , privacy , logOut , uname ;

    static String USER_NAME = "file";
    static String KEY_NAME = "name";
    SharedPreferences sd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_settings);

        getSupportActionBar().hide();

        uname = findViewById(R.id.Cuser);
        sd = getSharedPreferences(USER_NAME , MODE_PRIVATE);
        String name = sd.getString(KEY_NAME , null);

        if(name != null)
        {
            uname.setText("Hello "+name+"!");
        }else{
            uname.setText("Hello User!");
        }





        ImageView backbtn = findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        rate = findViewById(R.id.rate);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(moreSettings.this);
                bottomSheetDialog.setContentView(R.layout.rateusbottom);
                ImageView imageView = bottomSheetDialog.findViewById(R.id.close);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bottomSheetDialog.hide();
                    }
                });

//                RATING BAR
                TextView textView = bottomSheetDialog.findViewById(R.id.rateText);
                RatingBar ratingBar = bottomSheetDialog.findViewById(R.id.rateBar);
                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                        switch ((int) v)
                        {
                            case 1:
                                textView.setVisibility(View.VISIBLE);
                                textView.setText("Thank you !");
                                break;
                            case 2:
                                textView.setVisibility(View.VISIBLE);
                                textView.setText("Good Enough !");
                                break;
                            case 3:
                                textView.setVisibility(View.VISIBLE);
                                textView.setText("Great ! ");
                                break;
                            case 4:
                                textView.setVisibility(View.VISIBLE);
                                textView.setText("Awesome ! Thank You !");
                                break;
                            case 5:
                                textView.setVisibility(View.VISIBLE);
                                textView.setText("Wow, Thanks!");
                                break;
                            default:
                                textView.setVisibility(View.GONE);


                        }

                    }
                });

                bottomSheetDialog.show();
            }
        });






        share = findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent si = new Intent(Intent.ACTION_SEND);
                si.setType("text/plain");
                String body = "Share App with friends & family" + "\n\nhttps://drive.google.com/drive/u/1/folders/1BXkRUZhyigJK2ZZEuavGK8I7Evxq1CFd";
                String sub = "";
                si.putExtra(Intent.EXTRA_TEXT,body);
                si.putExtra(Intent.EXTRA_SUBJECT,sub);
                startActivity(Intent.createChooser(si,"Share Using"));

            }
        });

        about = findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), About.class);
                startActivity(intent);
            }
        });

        contact = findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "any.help.2021@gmail.com", null));
                startActivity(i);
            }
        });

        privacy = findViewById(R.id.privacy);
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://pages.flycricket.io/newshunt-0/privacy.html");

            }
        });



        logOut = findViewById(R.id.logOut);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(moreSettings.this );
                builder.setTitle("Logging Out !");
                builder.setMessage("Are you sure want to Log Out ??").setCancelable(false).
                        setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                moreSettings.super.onBackPressed();

                                SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME , MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.clear();
                                editor.apply();
                                startActivity(new Intent(moreSettings.this , login.class));


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
        });


    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW , uri));
    }

}