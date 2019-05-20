package com.example.mainproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditProfile extends AppCompatActivity {

    EditText majorInput;
    EditText gradDateInput;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        setTitle("Edit Your Profile");

        prefs = getSharedPreferences("mydata", MODE_PRIVATE);

        String major = prefs.getString("my_major", "");
        int gradDate = prefs.getInt("my_date", 2019);

        majorInput = findViewById(R.id.editmajor);
        gradDateInput = findViewById(R.id.editDate);

        majorInput.setText(major);
        gradDateInput.setText(Integer.toString(gradDate));
    }

    public void save(View view) {

        String major = majorInput.getText().toString();
        int gradDate = Integer.parseInt(gradDateInput.getText().toString());

        //save Data
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("my_major", major);
        editor.putInt("my_date", gradDate);
        editor.apply();


        Intent intent =  new Intent(this, Profile.class);
        startActivity(intent);

    }
}
