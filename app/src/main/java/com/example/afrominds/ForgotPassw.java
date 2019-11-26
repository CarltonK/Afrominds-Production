package com.example.afrominds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class ForgotPassw extends AppCompatActivity {
    private TextView reset;
    private EditText ema_il;

    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_passw);
        this.getSupportActionBar().hide();

        reset = findViewById(R.id.btn_reset);
        ema_il = findViewById(R.id.email_reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attempt_reset();
            }
        });
    }

    private void attempt_reset() {
        email = ema_il.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(email)) {
            ema_il.setError("Email is required");
            focusView = ema_il;
            cancel = true;

        }

        if (cancel) {
            focusView.requestFocus();
        }
        else{

            if (!isOnline(ForgotPassw.this)) {
                Toasty.warning(getApplicationContext(),"NO INTERNET CONNECTION",
                        Toast.LENGTH_LONG, true).show();
            } else {
                startActivity(new Intent(ForgotPassw.this, AfromindsMain.class));

            }
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ForgotPassw.this, Switcher.class));
        finish();
    }

    private boolean isOnline(Context mContext) {
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
