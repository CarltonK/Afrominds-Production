package com.example.afrominds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ForgotPassw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_passw);
        this.getSupportActionBar().hide();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ForgotPassw.this, Switcher.class));
    }
}
