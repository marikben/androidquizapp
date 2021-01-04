package com.example.inno3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBhelper extends SQLiteAssetHelper {
    private static final String DB_NAME = "inno.db";
    private static final int DATABASE_VERSION = 1;

    public DBhelper(Context context){
        super(context, DB_NAME, null, DATABASE_VERSION);


    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
