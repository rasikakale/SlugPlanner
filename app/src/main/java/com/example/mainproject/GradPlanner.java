package com.example.mainproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GradPlanner extends AppCompatActivity {

    Button year1;
    Button year2;
    Button year3;
    Button year4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grad_planner);
        setTitle("Graduation Planner");

        int grad = Profile.GradDate;

        year1 =  findViewById(R.id.firstyear);
        year2 =  findViewById(R.id.secondyear);
        year3 =  findViewById(R.id.thirdyear);
        year4 =  findViewById(R.id.fourthYear);


        year1.setText((Integer.toString(grad - 4)) + "-" + (Integer.toString(grad - 3)));
        year2.setText((Integer.toString(grad - 3)) + "-" + (Integer.toString(grad - 2)));
        year3.setText((Integer.toString(grad - 2)) + "-" + (Integer.toString(grad - 1)));
        year4.setText((Integer.toString(grad - 1)) + "-" + (Integer.toString(grad)));


        if(grad != 0) {
            Log.d("log", String.valueOf(grad));
        }


    }

    public void firstYear(View view) {
        Intent intent =  new Intent(this, firstyear.class);
        startActivity(intent);
    }

    public void secondYear(View view) {
        Intent intent =  new Intent(this, secondYear.class);
        startActivity(intent);
    }

    public void thirdYear(View view) {
        Intent intent =  new Intent(this, thirdYear.class);
        startActivity(intent);
    }

    public void fourthYear(View view) {
        Intent intent =  new Intent(this, fourthYear.class);
        startActivity(intent);
    }


    // back button to main menu
    public void menu(View view) {
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
