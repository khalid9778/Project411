package com.example.project411;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String  DATABASE_NAME = "Main_DB";
    public static final String TABLE_NAME = "User_Table";
    public static final String Col_1= "I.D.";
    public static final String Col2= "Name";
    public static final String Col3= "Password";
    public static final String Col4= "Phone_Number";
    public static final String Col5= "Email";



    public DataBaseHelper(Context context) {
        super(context,  DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Password TEXT,Phone_Number TEXT , Email TEXT)");}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME); //Drop older table if exists
        onCreate(db);

    }



}

