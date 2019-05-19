package com.example.mainproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDB extends SQLiteOpenHelper {

    SQLiteDatabase db;
    Context ctx;
    static String DB_NAME = "DATABASE";
    static String TABLE_NAME = "NAME_TABLE";
    static int VERSION = 1;

    public MyDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        ctx = context;
        VERSION = version;
        DB_NAME = name;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE NAME_TABLE (_id INTEGER PRIMARY KEY, FIRST_NAME STRING, LAST_NAME STRING);
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(_id INTEGER PRIMARY KEY, GPA DOUBLE, UNITS DOUBLE);");
        Toast.makeText(ctx, "TABLE IS CREATED", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //DROP TABLE IF EXISTS NAME_TABLE;
        if(VERSION == oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME + ";");
            VERSION = newVersion;
            onCreate(db);
            Toast.makeText(ctx, "TABLE IS UPGRAED", Toast.LENGTH_LONG).show();
        }

    }
    public void insert(Double gpa, Double units){
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("GPA", gpa);
        cv.put("UNITS", units);
        db.insert(TABLE_NAME, null, cv);
    }
    public void view(){
        db = getReadableDatabase();
        //Cursor c = db.query(TABLE_NAME, new String[]{"FIRST_NAME", "LAST_NAME"}, null, null, null, null, "LAST_NAME ASC");
        Cursor c = db.rawQuery("SELECT GPA, UNITS FROM " + TABLE_NAME+";", null);
        StringBuilder sb = new StringBuilder();
        while(c.moveToNext()){
            sb.append(c.getString(0) + " " + c.getString(1) + "\n");
        }
        Toast.makeText(ctx, sb.toString(), Toast.LENGTH_LONG).show();
    }

    public void delete(Double gpa, Double units) {
        db = getWritableDatabase();
        //db.delete(TABLE_NAME, "FIRST_NAME = ? AND LAST_NAME = ?", new String[]{firstname, lastname});
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE FIRST_NAME = \"" + gpa + "\" OR LAST_NAME = \"" + units + "\";");

    }

    public void update(Double gpa, Double units) {
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("GPA", gpa);
        cv.put("UNITS", units);
        //db.update(TABLE_NAME, cv, "FIRST_NAME = ? OR LAST_NAME = ?", new String[]{s, s1});
        db.execSQL("UPDATE " + TABLE_NAME + " SET GPA = \"" + gpa + "\", UNITS = \"" + units + "\" WHERE GPA = \"" + gpa + "\" OR UNITS = \"" + units + "\";");

    }

    public void count() {
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);
        Toast.makeText(ctx, String.valueOf(c.getCount()), Toast.LENGTH_LONG).show();
    }

    public void erase() {
        db = getWritableDatabase();
        onUpgrade(db, VERSION, VERSION + 1);
    }
}
