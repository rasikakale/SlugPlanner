package com.example.mainproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static MyDB db;
    public static ArrayList<String> arrayList_courses = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Slug Planner");
        db = new MyDB(this, "NAME_DATABASE", null, 1);
        new doIt().execute();

    }

    public void profile (View view) {
        Intent intent =  new Intent(this, Profile.class);
        startActivity(intent);

    }

    public void major (View view) {
        Intent intent =  new Intent(this, GradPlanner.class);
        startActivity(intent);

    }

    public void Classes(View view) {
        Intent intent =  new Intent(this, ClassProgress.class);
        startActivity(intent);
    }

    public void GPA(View view) {
        Intent intent = new Intent(this, GPA.class);
        startActivity(intent);

    }

    public void Date(View view) {
        Intent intent = new Intent(this, DatePrac.class);
        startActivity(intent);

    }

    public class  doIt extends AsyncTask<Void, Void, Void> {
        String course;
        String bread;
        Elements element;
        StringBuilder stringBuilder = new StringBuilder();
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect("https://courses.soe.ucsc.edu/courses/cse?year=2019").get();
                bread = doc.text();
                Elements titles = doc.getElementsByClass("course-name");
                for(Element title : titles) {
                    course = title.text();
                    stringBuilder.append(course).append("\n");
                    //contains all courses of CS BS
                    arrayList_courses.add(course);
                    Log.d("log", course);
                }
                Log.d("print courses", String.valueOf(arrayList_courses));
            } catch (IOException e) {
                Log.d("log", "in catch-charity");
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d("log", "about to print the classes");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.course_items, arrayList_courses);
        }
    }

}
