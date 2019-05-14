package com.example.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GradPlanner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grad_planner);
    }

    public void firstYear(View view) {
        Intent intent =  new Intent(this, firstyear.class);
        startActivity(intent);
    }

    public void secondYear(View view) {
        Intent intent =  new Intent(this, secondYear.class);
        startActivity(intent);
    }

    public void thirdYear(View view) {
        Intent intent =  new Intent(this, thirdYear.class);
        startActivity(intent);
    }

    public void fourthYear(View view) {
        Intent intent =  new Intent(this, fourthYear.class);
        startActivity(intent);
    }


    public void menu(View view) {
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
