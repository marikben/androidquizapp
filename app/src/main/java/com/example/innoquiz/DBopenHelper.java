package com.example.innoquiz;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBopenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "inno.db";
    private static final int DATABASE_VERSION =1;

    public DBopenHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
