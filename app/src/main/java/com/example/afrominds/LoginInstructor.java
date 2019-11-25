package com.example.afrominds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginInstructor extends AppCompatActivity {
    private EditText em_ail, pass_word;
    private TextView btn_login, forgot_pass;
    private CheckBox check_rem;
    private ImageView fb, google;

    //Key Identifiers
    String email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_instructor);
        this.getSupportActionBar().hide();

        //Define IDs
        em_ail = findViewById(R.id.eti_email);
        pass_word = findViewById(R.id.eti_password);
        btn_login = findViewById(R.id.btn_sign);
        forgot_pass = findViewById(R.id.forgotpass_ins);
        check_rem = findViewById(R.id.remember_ins);
        fb = findViewById(R.id.fb_ins);
        google = findViewById(R.id.google_ins);

        //Handle Edittext
        email = em_ail.getText().toString();
        password = pass_word.getText().toString();

        //Handle Clicks
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Empty returns
                if (TextUtils.isEmpty(email)) {
                    em_ail.setError("Email is required");

                }

                if (TextUtils.isEmpty(password)) {
                    pass_word.setError("Password is required");
                }
                else {

                    if (!isOnline(LoginInstructor.this)) {
                        Toast.makeText(getApplicationContext(), "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
                    } else {
                        startActivity(new Intent(LoginInstructor.this, AfromindsMain.class));
                        //loginprocess(email, password);
                    }

                }
            }
        });

        forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void loginprocess(String email, String password) {

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LoginInstructor.this, Switcher.class));
        finish();
    }

    private boolean isOnline(Context mContext) {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}