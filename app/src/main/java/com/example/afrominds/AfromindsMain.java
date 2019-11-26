package com.example.afrominds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import es.dmoral.toasty.Toasty;
import fragments.Blog;
import fragments.Courses;
import fragments.Home;
import fragments.Profile;

public class AfromindsMain extends AppCompatActivity {
    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afrominds_main);
        this.getSupportActionBar().hide();

        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        loadFragment(new Home());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new Home();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_blog:
                    fragment = new Blog();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_courses:
                    fragment = new Courses();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_account:
                    fragment = new Profile();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

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

                Toasty.info(getApplicationContext(),"See you next time....",
                        Toast.LENGTH_LONG, true).show();
                //sessionManager.logoutUser();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        }, 500);

    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
