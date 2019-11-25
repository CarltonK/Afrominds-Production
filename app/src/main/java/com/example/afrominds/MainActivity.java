package com.example.afrominds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView logo,afro,earn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        logo = findViewById(R.id.logo_splash);
        afro = findViewById(R.id.afro_splash);
        earn = findViewById(R.id.earn_splash);

        new CountDownTimer(1000, 3000) {

            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                Animation push_down_in = AnimationUtils.loadAnimation(getBaseContext(),R.anim.push_down_in);
                logo.setVisibility(View.VISIBLE);
                logo.setAnimation(push_down_in);

                new CountDownTimer(1000, 3000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }
                    @Override
                    public void onFinish() {
                        afro.animate().alpha(1f).setDuration(500);

                        new CountDownTimer(1000, 3000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                            }
                            @Override
                            public void onFinish() {
                                earn.animate().alpha(1f).setDuration(500);

                                new CountDownTimer(1000, 3000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                    }
                                    @Override
                                    public void onFinish() {
                                        startActivity(new Intent(MainActivity.this,Switcher.class));
                                        finish();
                                    }

                                }.start();
                            }

                        }.start();
                    }

                }.start();
            }

        }.start();
    }
}
