package com.example.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Slug Planner");
    }

    public void profile (View view) {
        Intent intent =  new Intent(this, Profile.class);
        startActivity(intent);

    }

    public void major (View view) {
        Intent intent =  new Intent(this, GradPlanner.class);
        startActivity(intent);

    }

    public void Classes(View view) {
        Intent intent =  new Intent(this, ClassProgress.class);
        startActivity(intent);
    }
}
