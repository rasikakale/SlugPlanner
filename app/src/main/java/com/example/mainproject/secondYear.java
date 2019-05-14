package com.example.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class secondYear extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_year);
    }

    public void backToPlanner(View view) {
        Intent intent = new Intent(this, GradPlanner.class);
        startActivity(intent);
    }

    }

