package com.example.mainproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class GPA extends AppCompatActivity {


    EditText gpa;
    EditText units;
    EditText oneClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gp);
        gpa = findViewById(R.id.GPAValue);
        units = findViewById(R.id.units);
        oneClass = findViewById(R.id.singleClass);
    }

    public void calculate(View view){
      int gpaVal  = Integer.parseInt(gpa.getText().toString());
      int unitVal  = Integer.parseInt(units.getText().toString());
      String singleClass = oneClass.getText().toString();
      double classVal;

      if(singleClass.equals("A+")){
          classVal = 4;
      } else if(singleClass.equals("A")){
          classVal = 4;
      } else if(singleClass.equals("A-")){
            classVal = 3.7;
      } else if(singleClass.equals("B+")){
            classVal = 3.3;
      } else if(singleClass.equals("B")){
            classVal = 3.0;
      } else if(singleClass.equals("B-")){
          classVal = 2.7;
      } else if(singleClass.equals("C+")){
          classVal = 2.3;
      } else if(singleClass.equals("C")){
          classVal = 2;
      } else if(singleClass.equals("C-")){
          classVal = 1.7;
      } else if(singleClass.equals("D+")){
          classVal = 1.3;
      } else if(singleClass.equals("D")){
          classVal = 1.0;
      } else if(singleClass.equals("D-")){
          classVal = 0.7;
      } else {
          classVal = 0;
      }





        double gpaQuarterPoints = gpaVal * unitVal;
        double gpaClassPoints = classVal * unitVal;

        Log.d("GPAPoints", String.valueOf(gpaQuarterPoints));
        Log.d("Gpa", String.valueOf(gpaClassPoints));



    }





}
