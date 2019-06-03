package com.example.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.util.ArrayList;

public class fourthYear extends AppCompatActivity {
    EditText fall1, fall2, fall3;
    EditText winter1, winter2, winter3;
    EditText spring1, spring2, spring3;

    ArrayList<String> arrayList_courses = MainActivity.arrayList_courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_year);
        setTitle("Fourth Year");

        fall1 = findViewById(R.id.fall1);
        fall2 = findViewById(R.id.fall2);
        fall3 = findViewById(R.id.fall3);

        winter1 = findViewById(R.id.winter1);
        winter2 = findViewById(R.id.winter2);
        winter3 = findViewById(R.id.winter3);

        spring1 = findViewById(R.id.spring1);
        spring2 = findViewById(R.id.spring2);
        spring3 = findViewById(R.id.spring3);


        Log.d("course", "hello");
        Log.d("course", String.valueOf(arrayList_courses));

//        fall set the search bars
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.fall1);
        AutoCompleteTextView autoCompleteTextView2 = findViewById(R.id.fall2);
        AutoCompleteTextView autoCompleteTextView3 = findViewById(R.id.fall3);
        autoCompleteTextView.setThreshold(1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList_courses);
        autoCompleteTextView.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList_courses);
        autoCompleteTextView2.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList_courses);
        autoCompleteTextView3.setAdapter(adapter3);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // fall1.setText("" + parent.getSelectedItem());
            }
        });
//        winter set the search bars
        AutoCompleteTextView autoCompleteTextViewWT1 = findViewById(R.id.winter1);
        AutoCompleteTextView autoCompleteTextViewWT2 = findViewById(R.id.winter2);
        AutoCompleteTextView autoCompleteTextViewWT3 = findViewById(R.id.winter3);
        ArrayAdapter<String> adapterWT1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList_courses);
        autoCompleteTextViewWT1.setAdapter(adapterWT1);
        ArrayAdapter<String> adapterWT2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList_courses);
        autoCompleteTextViewWT2.setAdapter(adapterWT2);
        ArrayAdapter<String> adapterWT3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList_courses);
        autoCompleteTextViewWT3.setAdapter(adapterWT3);
//        spring set the search bars
        AutoCompleteTextView autoCompleteTextViewSP1 = findViewById(R.id.spring1);
        AutoCompleteTextView autoCompleteTextViewSP2 = findViewById(R.id.spring2);
        AutoCompleteTextView autoCompleteTextViewSP3 = findViewById(R.id.spring3);

        ArrayAdapter<String> adapterSP1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList_courses);
        autoCompleteTextViewSP1.setAdapter(adapterSP1);
        ArrayAdapter<String> adapterSP2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList_courses);
        autoCompleteTextViewSP2.setAdapter(adapterSP2);
        ArrayAdapter<String> adapterSP3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList_courses);
        autoCompleteTextViewSP3.setAdapter(adapterSP3);
    }

    public void backToPlanner(View view) {
        Intent intent = new Intent(this, GradPlanner.class);
        startActivity(intent);
    }
}
