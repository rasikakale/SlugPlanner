package com.example.mainproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class GPA2 extends AppCompatActivity {


    EditText gpa1;
    EditText unitVal1;
    EditText oneClass1;

    EditText gpa2;
    EditText unitVal2;
    EditText oneClass2;

    EditText gpa3;
    EditText unitVal3;
    EditText oneClass3;
    Context ctx;
    TextView gpaTextView;
    public static double totalGPA;
    public static double unitTotal;

    TextView gpaProfile;

    public static double overallGPA;
    public static double overallUnits;
    private static DecimalFormat df = new DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa2);
        //gpa1 = findViewById(R.id.GPAValue);

        SharedPreferences prefs = getSharedPreferences("mydata", MODE_PRIVATE);


        unitVal1 = findViewById(R.id.units1);
        oneClass1 = findViewById(R.id.singleClass1);

        unitVal2 = findViewById(R.id.units2);
        oneClass2 = findViewById(R.id.singleClass2);

        unitVal3 = findViewById(R.id.units3);
        oneClass3 = findViewById(R.id.singleClass3);

        gpaTextView = findViewById(R.id.gpaTextView);
        //gpaProfile = findViewById();


    }


    public void calculate(View view) {
        // int gpaVal1  = Integer.parseInt(gpa1.getText().toString());
        double unitValue1 = Double.parseDouble(unitVal1.getText().toString());
        String singleClass1 = oneClass1.getText().toString();
        double classVal1;


        double unitValue2 = Double.parseDouble(unitVal2.getText().toString());
        String singleClass2 = oneClass2.getText().toString();
        double classVal2;

        //int gpaVal3  = Integer.parseInt(gpa3.getText().toString());
        double unitValue3 = Double.parseDouble(unitVal3.getText().toString());
        String singleClass3 = oneClass3.getText().toString();
        double classVal3;

        if (singleClass1.equals("A+")) {
            classVal1 = 4;
        } else if (singleClass1.equals("A")) {
            classVal1 = 4;
        } else if (singleClass1.equals("A-")) {
            classVal1 = 3.7;
        } else if (singleClass1.equals("B+")) {
            classVal1 = 3.3;
        } else if (singleClass1.equals("B")) {
            classVal1 = 3.0;
        } else if (singleClass1.equals("B-")) {
            classVal1 = 2.7;
        } else if (singleClass1.equals("C+")) {
            classVal1 = 2.3;
        } else if (singleClass1.equals("C")) {
            classVal1 = 2;
        } else if (singleClass1.equals("C-")) {
            classVal1 = 1.7;
        } else if (singleClass1.equals("D+")) {
            classVal1 = 1.3;
        } else if (singleClass1.equals("D")) {
            classVal1 = 1.0;
        } else if (singleClass1.equals("D-")) {
            classVal1 = 0.7;
        } else {
            classVal1 = 0;
        }


        if (singleClass2.equals("A+")) {
            classVal2 = 4;
        } else if (singleClass2.equals("A")) {
            classVal2 = 4;
        } else if (singleClass2.equals("A-")) {
            classVal2 = 3.7;
        } else if (singleClass2.equals("B+")) {
            classVal2 = 3.3;
        } else if (singleClass2.equals("B")) {
            classVal2 = 3.0;
        } else if (singleClass2.equals("B-")) {
            classVal2 = 2.7;
        } else if (singleClass2.equals("C+")) {
            classVal2 = 2.3;
        } else if (singleClass2.equals("C")) {
            classVal2 = 2;
        } else if (singleClass2.equals("C-")) {
            classVal2 = 1.7;
        } else if (singleClass2.equals("D+")) {
            classVal2 = 1.3;
        } else if (singleClass2.equals("D")) {
            classVal2 = 1.0;
        } else if (singleClass2.equals("D-")) {
            classVal2 = 0.7;
        } else {
            classVal2 = 0;
        }


        if (singleClass3.equals("A+")) {
            classVal3 = 4;
        } else if (singleClass3.equals("A")) {
            classVal3 = 4;
        } else if (singleClass3.equals("A-")) {
            classVal3 = 3.7;
        } else if (singleClass3.equals("B+")) {
            classVal3 = 3.3;
        } else if (singleClass3.equals("B")) {
            classVal3 = 3.0;
        } else if (singleClass3.equals("B-")) {
            classVal3 = 2.7;
        } else if (singleClass3.equals("C+")) {
            classVal3 = 2.3;
        } else if (singleClass3.equals("C")) {
            classVal3 = 2;
        } else if (singleClass3.equals("C-")) {
            classVal3 = 1.7;
        } else if (singleClass3.equals("D+")) {
            classVal3 = 1.3;
        } else if (singleClass3.equals("D")) {
            classVal3 = 1.0;
        } else if (singleClass3.equals("D-")) {
            classVal3 = 0.7;
        } else {
            classVal3 = 0;
        }


        //  double gpaQuarterPoints1 = gpaVal1 * unitVal1;
        // double gpaQuarterPoints2 = gpaVal2 * unitVal2;
        // double gpaQuarterPoints3 = gpaVal3 * unitVal3;

        unitTotal = unitValue1 + unitValue2 + unitValue3;

        double gpaClassPoints1 = classVal1 * unitValue1;
        double gpaClassPoints2 = classVal2 * unitValue2;
        double gpaClassPoints3 = classVal3 * unitValue3;

        totalGPA = ((gpaClassPoints1 + gpaClassPoints2 + gpaClassPoints3) / unitTotal);

        gpaTextView.setText("Quarter GPA: " + String.valueOf(totalGPA));


        overallGPA = .00000000001;

        overallGPA = Double.parseDouble(Profile.GPA.getText().toString());

        overallUnits = Double.parseDouble(Profile.unitsText.getText().toString());


        overallGPA = ((overallGPA * overallUnits) + (totalGPA * unitTotal)) / (overallUnits + unitTotal);
        overallUnits = overallUnits + unitTotal;

        df.setRoundingMode(RoundingMode.UP);
        overallGPA = Double.parseDouble(df.format(overallGPA));


        SharedPreferences prefs = getSharedPreferences("mydata", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("GPA", Double.toString(GPA2.overallGPA));
        editor.putString("UNITS", Double.toString(GPA2.overallUnits));
        editor.commit();

//
//
//        Profile.GPA.setText(String.valueOf(overallGPA));


        //Toast.makeText(ctx, "GPA Points: " + (gpaQuarterPoints), Toast.LENGTH_LONG).show();

        Log.d("GPAPoint", String.valueOf(overallGPA));

        System.out.printf("Value with 3 digits after decimal point %.3f %n", totalGPA);
        df.setRoundingMode(RoundingMode.UP);
        totalGPA = Double.parseDouble(df.format(totalGPA));
        Log.d("GPAPoints", String.valueOf(totalGPA));
        // Log.d("Gpa", String.valueOf(gpaClassPoints));


        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);


    }


}