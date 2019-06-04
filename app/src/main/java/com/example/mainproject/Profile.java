package com.example.mainproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.*;
import java.util.Locale;


public class Profile extends AppCompatActivity {

    static int GradDate = 2019;
    public static TextView GPA,unitsText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");


        SharedPreferences prefs = getSharedPreferences("mydata", MODE_PRIVATE);

        String major = prefs.getString("my_major", "Enter major");
        GradDate = prefs.getInt("my_date", 2019);
        String name = prefs.getString("my_name", "Enter Name");

        ((TextView)findViewById(R.id.Majortext1)).setText(major);
        ((TextView)findViewById(R.id.gradDate)).setText((Integer.toString(GradDate)));
        ((TextView)findViewById(R.id.ViewName)).setText(name);



        
        //PROFILE
        String gpaText = prefs.getString("GPA", String.valueOf(0));
        String unitText = prefs.getString("UNITS", String.valueOf(0));


        GPA = findViewById(R.id.GPA);
        unitsText = findViewById(R.id.unitsText);
        GPA.setText(gpaText);
        unitsText.setText(unitText);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        Date otherDate = new Date(2019, 2,7);

    }



    public void backToMenu(View view) {
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void edit(View view) {
        Intent intent =  new Intent(this, EditProfile.class);
        startActivity(intent);

    }


    public void GPA(View view) {
        Intent intent = new Intent(this, GPA2.class);
        startActivity(intent);

    }

}


