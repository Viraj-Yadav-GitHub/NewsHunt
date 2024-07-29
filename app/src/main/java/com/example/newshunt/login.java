package com.example.newshunt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newshunt.Fragments.HomeFragment;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    Button LoginBtn , register;
    TextView singUpBtn , loginBack ;
    TextInputLayout username_var , pass_var ;
    LinearLayout loginLL , singupLL ;
    TextInputLayout username, password, phone, name;


    FirebaseDatabase firebaseDatabase ;
    DatabaseReference reference ;

    static String PREFS_NAME = "myPrefFiles";
    static String USER_NAME = "file";
    static String KEY_NAME = "name";
    SharedPreferences sd ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        singUpBtn = findViewById(R.id.signUpPg);
        LoginBtn = findViewById(R.id.loginBtn);
        username_var = findViewById(R.id.UserNameField);
        pass_var = findViewById(R.id.PasswordField);

        loginBack = findViewById(R.id.backToLog);

        loginLL = findViewById(R.id.LoginLayout);
        singupLL = findViewById(R.id.signUpLayout);

        register = findViewById(R.id.registerAcc);
        username = findViewById(R.id.UserNameSU);
        password = findViewById(R.id.PasswordSU);
        phone = findViewById(R.id.PhoneField);
        name = findViewById(R.id.nameField);

        sd = getSharedPreferences(USER_NAME , MODE_PRIVATE);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        loginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                singupLL.setVisibility(View.INVISIBLE);

            }
        });


        singUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                singupLL.setVisibility(View.VISIBLE);


            }
        });



        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_ = username_var.getEditText().getText().toString();
                String password_ = pass_var.getEditText().getText().toString();

                if (!username_.isEmpty()) {
                    username_var.setError(null);
                    username_var.setErrorEnabled(false);

                    if (!password_.isEmpty()) {
                        pass_var.setError(null);
                        pass_var.setErrorEnabled(false);

                        final String username_data = username_var.getEditText().getText().toString();
                        final String pass_data = pass_var.getEditText().getText().toString();

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference databaseReference = firebaseDatabase.getReference("datauser");

                        Query check_username = databaseReference.orderByChild("username").equalTo(username_data);

                        check_username.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                if (snapshot.exists()) {

                                    username_var.setError(null);
                                    username_var.setErrorEnabled(false);
                                    String pass_check = snapshot.child(username_data).child("password").getValue(String.class);

                                    if (pass_check.equals(pass_data)) {
                                        pass_var.setError(null);
                                        pass_var.setErrorEnabled(false);
                                        Toast.makeText(getApplicationContext(), "Login Successfully !", Toast.LENGTH_LONG).show();

                                        SharedPreferences sharedPreferences = getSharedPreferences(login.PREFS_NAME , MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putBoolean("hasLoggedIn" ,true);
                                        editor.commit();

                                        SharedPreferences.Editor editor1 = sd.edit();
                                        editor1.putString(KEY_NAME , username_);
                                        editor1.apply();


                                        startActivity(new Intent(login.this , MainActivity.class));
                                        finish();

                                    } else {
                                        pass_var.setError("Password could not match !");
                                    }

                                } else {
                                    username_var.setError("Username does not found !");
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });


                    } else {
                        pass_var.setError("Please enter password");
                    }

                } else {
                    username_var.setError("Please enter username");
                }


            }
        });



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name_ = name.getEditText().getText().toString();
                String userSU_ = username.getEditText().getText().toString();
                String phone_ = phone.getEditText().getText().toString();
                String pass_ = password.getEditText().getText().toString();

                if (!name_.isEmpty()) {
                    name.setError(null);
                    name.setErrorEnabled(false);
                    if (!userSU_.isEmpty()) {
                        username.setError(null);
                        username.setErrorEnabled(false);
                        if (!phone_.isEmpty()) {
                            phone.setError(null);
                            phone.setErrorEnabled(false);
                            if (!pass_.isEmpty()) {
                                password.setError(null);
                                password.setErrorEnabled(false);

                                firebaseDatabase = FirebaseDatabase.getInstance();
                                reference = firebaseDatabase.getReference("datauser");

                                String name_s = name.getEditText().getText().toString();
                                String userSU_s = username.getEditText().getText().toString();
                                String phone_s = phone.getEditText().getText().toString();
                                String pass_s = password.getEditText().getText().toString();

                                StoringData storingData = new StoringData(name_s , userSU_s ,phone_s ,pass_s);
                                reference.child(userSU_s).setValue(storingData);

                                Toast.makeText(getApplicationContext(), "Register Account Successfully !", Toast.LENGTH_LONG).show();


                                SharedPreferences sharedPreferences = getSharedPreferences(login.PREFS_NAME , MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putBoolean("hasLoggedIn" ,true);
                                editor.commit();

                                SharedPreferences.Editor editor1 = sd.edit();
                                editor1.putString(KEY_NAME , userSU_);
                                editor1.apply();
                                startActivity(new Intent(login.this , MainActivity.class));
                                finish();









                            } else {
                                password.setError("Please enter password");
                            }

                        } else {
                            phone.setError("Please enter phone number");
                        }

                    } else {
                        username.setError("Please enter username");
                    }
                } else {
                    name.setError("Please enter full name");
                }

            }
        });


    }






    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this );
        builder.setTitle("EXIT !!");
        builder.setMessage("Are you sure want to Exit ??").setCancelable(false).
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        login.super.onBackPressed();
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