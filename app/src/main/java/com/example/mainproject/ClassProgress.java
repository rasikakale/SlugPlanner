package com.example.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ClassProgress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_progress);
        setTitle("Class Progress");
    }

    public void classesLeft(View view) {
        Intent intent =  new Intent(this, ClassesLeft.class);
        startActivity(intent);

    }

    public void menu(View view) {
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void classesDone(View view) {
        Intent intent =  new Intent(this, ClassesDone.class);
        startActivity(intent);
    }
}
