package com.example.afrominds;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AfromindsMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afrominds_main);
        this.getSupportActionBar().hide();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        /*
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(

                R.id.navigation_home, R.id.navigation_blog, R.id.navigation_courses)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
         */
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("EXIT")
                .setMessage("Are you sure ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SignOut();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void SignOut() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(getApplicationContext(),"See you next time....", Toast.LENGTH_LONG).show();
                //sessionManager.logoutUser();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        }, 500);

    }
}
