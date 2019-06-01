package com.example.mainproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DatePrac extends AppCompatActivity {

    TextView setDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_prac);
        setDate = findViewById(R.id.DateBox);
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        setDate.setText(date);
    }


    //String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());



}
