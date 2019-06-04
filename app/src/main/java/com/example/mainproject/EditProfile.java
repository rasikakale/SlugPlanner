package com.example.mainproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class EditProfile extends AppCompatActivity {

    EditText majorInput;
    EditText gradDateInput;
    EditText nameInput;
    SharedPreferences prefs;

    private static final String[] majors = new String[]{
            "Bioengineering B.S", "Bioinformatics B.S.", "Computer Engineering B.S.", "Computer Science B.A.",
            "Computer Science B.S.", "Computer Game Design B.S.", "Electrical Engineering B.S.", "Network and Digital Technology B.A.",
            "Robotics Engineering B.S.","Technology and Information Management B.S."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        setTitle("Edit Your Profile");

        prefs = getSharedPreferences("mydata", MODE_PRIVATE);

        String major = prefs.getString("my_major", "");
        int gradDate = prefs.getInt("my_date", 2019);
        String name = prefs.getString("my_name", "");

        majorInput = findViewById(R.id.editmajor);
        gradDateInput = findViewById(R.id.editDate);
        nameInput = findViewById(R.id.EditName);

        nameInput.setText(name);
        majorInput.setText(major);
        gradDateInput.setText(Integer.toString(gradDate));

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.editmajor);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, majors);
        autoCompleteTextView.setAdapter(adapter);
    }

    public void save(View view) {

        String name = nameInput.getText().toString();
        String major = majorInput.getText().toString();
        int gradDate = Integer.parseInt(gradDateInput.getText().toString());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("my_major", major);
        editor.putInt("my_date", gradDate);
        editor.putString("my_name", name);
        editor.apply();


        Intent intent =  new Intent(this, Profile.class);
        startActivity(intent);

    }
}
