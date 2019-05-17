package com.example.mainproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class GPA2 extends AppCompatActivity {


    //EditText gpa1;
    EditText units1;
    EditText oneClass1;

    //EditText gpa2;
    EditText units2;
    EditText oneClass2;

    //EditText gpa3;
    EditText units3;
    EditText oneClass3;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa2);
        //gpa1 = findViewById(R.id.GPAValue);

        units1 = findViewById(R.id.units1);
        oneClass1 = findViewById(R.id.singleClass1);

        units2 = findViewById(R.id.units2);
        oneClass2 = findViewById(R.id.singleClass2);

        units3 = findViewById(R.id.units3);
        oneClass3 = findViewById(R.id.singleClass3);
    }

    public void calculate(View view){
       // int gpaVal1  = Integer.parseInt(gpa1.getText().toString());
        double unitVal1  = Double.parseDouble(units1.getText().toString());
        String singleGrade1 = oneClass1.getText().toString();
        double classVal1;


        double unitVal2  = Double.parseDouble(units1.getText().toString());
        String singleGrade2 = oneClass2.getText().toString();
        double classVal2;

        //int gpaVal3  = Integer.parseInt(gpa3.getText().toString());
        double unitVal3  = Double.parseDouble(units1.getText().toString());
        String singleGrade3 = oneClass3.getText().toString();
        double classVal3;

        if(singleGrade1.equals("A+")){
            classVal1 = 4;
        } else if(singleGrade1.equals("A")){
            classVal1 = 4;
        } else if(singleGrade1.equals("A-")){
            classVal1 = 3.7;
        } else if(singleGrade1.equals("B+")){
            classVal1 = 3.3;
        } else if(singleGrade1.equals("B")){
            classVal1 = 3.0;
        } else if(singleGrade1.equals("B-")){
            classVal1 = 2.7;
        } else if(singleGrade1.equals("C+")){
            classVal1 = 2.3;
        } else if(singleGrade1.equals("C")){
            classVal1 = 2;
        } else if(singleGrade1.equals("C-")){
            classVal1 = 1.7;
        } else if(singleGrade1.equals("D+")){
            classVal1 = 1.3;
        } else if(singleGrade1.equals("D")){
            classVal1 = 1.0;
        } else if(singleGrade1.equals("D-")){
            classVal1 = 0.7;
        } else {
            classVal1 = 0;
        }


        if(singleGrade2.equals("A+")){
            classVal2 = 4;
        } else if(singleGrade2.equals("A")){
            classVal2 = 4;
        } else if(singleGrade2.equals("A-")){
            classVal2 = 3.7;
        } else if(singleGrade2.equals("B+")){
            classVal2 = 3.3;
        } else if(singleGrade2.equals("B")){
            classVal2 = 3.0;
        } else if(singleGrade2.equals("B-")){
            classVal2 = 2.7;
        } else if(singleGrade2.equals("C+")){
            classVal2 = 2.3;
        } else if(singleGrade2.equals("C")){
            classVal2 = 2;
        } else if(singleGrade2.equals("C-")){
            classVal2 = 1.7;
        } else if(singleGrade2.equals("D+")){
            classVal2 = 1.3;
        } else if(singleGrade2.equals("D")){
            classVal2 = 1.0;
        } else if(singleGrade2.equals("D-")){
            classVal2 = 0.7;
        } else {
            classVal2 = 0;
        }







        if(singleGrade3.equals("A+")){
            classVal3 = 4;
        } else if(singleGrade3.equals("A")){
            classVal3 = 4;
        } else if(singleGrade3.equals("A-")){
            classVal3 = 3.7;
        } else if(singleGrade3.equals("B+")){
            classVal3 = 3.3;
        } else if(singleGrade3.equals("B")){
            classVal3 = 3.0;
        } else if(singleGrade3.equals("B-")){
            classVal3 = 2.7;
        } else if(singleGrade3.equals("C+")){
            classVal3 = 2.3;
        } else if(singleGrade3.equals("C")){
            classVal3 = 2;
        } else if(singleGrade3.equals("C-")){
            classVal3 = 1.7;
        } else if(singleGrade3.equals("D+")){
            classVal3 = 1.3;
        } else if(singleGrade3.equals("D")){
            classVal3 = 1.0;
        } else if(singleGrade3.equals("D-")){
            classVal3 = 0.7;
        } else {
            classVal3 = 0;
        }














      //  double gpaQuarterPoints1 = gpaVal1 * unitVal1;
       // double gpaQuarterPoints2 = gpaVal2 * unitVal2;
        // double gpaQuarterPoints3 = gpaVal3 * unitVal3;


        double unitTotal = unitVal1 + unitVal2 + unitVal3;

       double gpaClassPoints1 = classVal1 * unitVal1;
       double gpaClassPoints2 = classVal2 * unitVal2;
       double gpaClassPoints3 = classVal3 * unitVal3;

        double totalGPA = ((gpaClassPoints1+gpaClassPoints2+gpaClassPoints3)/unitTotal);

        MainActivity.db.insert(totalGPA, unitTotal);





        //Toast.makeText(ctx, "GPA Points: " + (gpaQuarterPoints), Toast.LENGTH_LONG).show();


        Log.d("GPAPoints", String.valueOf(totalGPA));
       // Log.d("Gpa", String.valueOf(gpaClassPoints));



    }





}
