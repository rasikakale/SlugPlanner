package com.example.mainproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import org.w3c.dom.Text;


public class Profile extends AppCompatActivity {

    static int GradDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");


        SharedPreferences prefs = getSharedPreferences("mydata", MODE_PRIVATE);

        String major = prefs.getString("my_major", "Enter major");
        GradDate = prefs.getInt("my_date", 2019);

        ((TextView)findViewById(R.id.Majortext1)).setText(major);
        ((TextView)findViewById(R.id.gradDate)).setText((Integer.toString(GradDate)));


    }



    public void backToMenu(View view) {
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void edit(View view) {
        Intent intent =  new Intent(this, EditProfile.class);
        startActivity(intent);

    }
}
