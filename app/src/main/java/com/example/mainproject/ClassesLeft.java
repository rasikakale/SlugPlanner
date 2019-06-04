package com.example.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ClassesLeft extends AppCompatActivity {

    public static ListView classDoneListView;
    public static ArrayAdapter<String> mAdapter;
    public static ArrayList<String> sel_courses = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_left);
        setTitle("Classes to Complete");

        classDoneListView = (ListView) findViewById(R.id.ClassesDoneView);
        mAdapter = new ArrayAdapter<String>(ClassesLeft.this, R.layout.sample_view, sel_courses);
        classDoneListView.setAdapter(mAdapter);

    }

    public void back(View view) {

        Intent intent =  new Intent(this, ClassProgress.class);
        startActivity(intent);

    }
}
