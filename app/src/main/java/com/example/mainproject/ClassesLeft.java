package com.example.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ClassesLeft extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_left);
        setTitle("Classes to Complete");

    }

    public void back(View view) {
        Intent intent =  new Intent(this, ClassProgress.class);
        startActivity(intent);

    }
}
