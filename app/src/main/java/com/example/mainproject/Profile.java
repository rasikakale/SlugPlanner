package com.example.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    TextView GPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");
        GPA = findViewById(R.id.gpatext);
    }

    


    public void backToMenu(View view) {
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
