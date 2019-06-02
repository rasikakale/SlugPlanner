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
    ArrayList<String> arrayList_courses = new ArrayList<String>();
    //ArrayList<String> selected_courses = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_done);

        //courseText = (TextView) findViewById(R.id.courseName);
        listView = (ListView) findViewById(R.id.listViewID);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        setTitle("Course List");
        //Button button = (Button) findViewById(R.id.courseButton);

        new doIt().execute();
    /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new doIt().execute();
            }
        });
        */
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
                // element = doc.select("div.body-wrapper");
                //bread = element.select("div.breadcrumb h1").text();

                bread = doc.text();
                //System.out.println(bread);
//                Elements titles = doc.select("#block-system-main > div > table > tbody > tr:nth-child(5) > td");
                Elements titles = doc.getElementsByClass("course-name");
                for(Element title : titles) {
                    course = title.text();
                    stringBuilder.append(course).append("\n");

                    //contains all courses of CS BS
                    arrayList_courses.add(course);
                    Log.d("log", course);
                }

//                Elements elements = doc.select("table#soe-classes-schedule");
//                for(Element element: elements.select("table.course-name")){
//                    String className = element.select("table.course-name").attr("href");
//                    System.out.println(className);
//                }
                // String title


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
           // courseText.setText(stringBuilder.toString());
            //courseText.setMovementMethod(new ScrollingMovementMethod());

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(ClassesDone.this, R.layout.course_items, arrayList_courses);
            listView.setAdapter(adapter);
        }
    }





}

