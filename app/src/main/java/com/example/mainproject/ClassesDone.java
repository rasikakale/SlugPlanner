package com.example.mainproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ClassesDone extends AppCompatActivity {
    //TextView courseText;
    ListView listView;
    public static ArrayList<String> arrayList_courses = new ArrayList<String>();
    //ArrayList<String> selected_courses = new ArrayList<String>();

    private static final String[] CSEcourses = new String[]{
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_done);
        listView = (ListView) findViewById(R.id.listViewID);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        setTitle("Course List");
        new doIt().execute();
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
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(ClassesDone.this, R.layout.course_items, arrayList_courses);
            listView.setAdapter(adapter);
        }
    }
}

