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

public class LoginStudent extends AppCompatActivity {
    private EditText emai_l, pass_word;
    private TextView sign_in, forgot_pass;
    private CheckBox remembe_r;
    private ImageView fb, google;

    //Key Identifiers
    String email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getSupportActionBar().hide();

        //Define IDs
        emai_l = findViewById(R.id.et_email);
        pass_word = findViewById(R.id.et_password);
        sign_in = findViewById(R.id.btn_signin);
        forgot_pass = findViewById(R.id.forgotpass);
        remembe_r = findViewById(R.id.remember);
        fb = findViewById(R.id.fb_stu);
        google = findViewById(R.id.google_stu);

        //Handle Edittext
        email = emai_l.getText().toString();
        password = pass_word.getText().toString();

        //Handle Clicks
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Empty returns
                if (TextUtils.isEmpty(email)) {
                    emai_l.setError("Email is required");
                }

                if (TextUtils.isEmpty(password)) {
                    pass_word.setError("Password is required");
                }

                else {

                    if (!isOnline(LoginStudent.this)) {
                        Toast.makeText(getApplicationContext(), "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
                    } else {
                        startActivity(new Intent(LoginStudent.this, AfromindsMain.class));
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
        startActivity(new Intent(LoginStudent.this, Switcher.class));
        finish();
    }

    private boolean isOnline(Context mContext) {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
