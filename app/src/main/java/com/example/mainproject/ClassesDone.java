package com.example.mainproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ClassesDone extends AppCompatActivity {
    EditText courseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_done);

        courseText = (EditText) findViewById(R.id.courseText);
        Button button = (Button) findViewById(R.id.courseButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new doIt().execute();
            }
        });
    }


    public class doIt extends AsyncTask<Void, Void, Void> {
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
                    Log.d("log", course);
                }
//
//                Elements elements = doc.select("table#soe-classes-schedule");
//                for(Element element: elements.select("table.course-name")){
//                    String className = element.select("table.course-name").attr("href");
//                    System.out.println(className);
//                }
                // String title


            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            courseText.setText(stringBuilder);
        }
    }





}

