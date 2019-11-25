package com.example.afrominds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Switcher extends AppCompatActivity {
    TextView student, instructor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switcher);
        this.getSupportActionBar().hide();

        student = findViewById(R.id.tv_student);
        instructor = findViewById(R.id.tv_instructor);

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Switcher.this, LoginStudent.class));
                finish();
            }
        });

        instructor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Switcher.this, LoginInstructor.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
