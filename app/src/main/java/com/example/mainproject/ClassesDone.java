package com.example.mainproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class ClassesDone extends AppCompatActivity {
    //TextView courseText;
    ListView listView;
    public static ArrayList<String> arrayList_courses = new ArrayList<String>();
    public static ArrayList<String> selected_courses = new ArrayList<String>();

    ListView classesDonelist = ClassesLeft.classDoneListView;
    ArrayAdapter<String> stringArrayAdapter = ClassesLeft.mAdapter;
    ArrayList<String> new_courses = ClassesLeft.sel_courses;


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

    public void classesDone(View view) {
        Intent intent = new Intent(this, ClassProgress.class);
        startActivity(intent);

    }



    public void showSelectedClasses(View view) {
        String courses = "";
        for(String course: selected_courses) {
                courses += "-" + course + "\n";
        }
        Log.d("selected courses", courses);
        Toast.makeText(this, "You have selected: \n" + courses, Toast.LENGTH_LONG).show();


    }


    public void addClasses(View view) {

        Toast.makeText(this, "Classes Added to Classes Completed!", Toast.LENGTH_LONG).show();

        new_courses.addAll(selected_courses);
        arrayList_courses.removeAll(selected_courses);

        Intent intent = new Intent(this, ClassesLeft.class);
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
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(ClassesDone.this, R.layout.course_items, arrayList_courses);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String selectedcourse = ((TextView)view).getText().toString();
                    if (selected_courses.contains(selectedcourse)) {
                        selected_courses.remove(selectedcourse);

                    } else {
                        selected_courses.add(selectedcourse);
                    }

                }
            });
        }


    }
}

