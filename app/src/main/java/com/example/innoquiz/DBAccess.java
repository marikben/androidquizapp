package com.example.innoquiz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DBAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;

    private static DBAccess instance;
    Cursor c =null;

    private DBAccess(Context context){
        this.openHelper = new DBopenHelper(context);
    }

    public static DBAccess getInstance(Context context){
        if(instance==null){
            instance = new DBAccess(context);
        }
        return instance;
    }

    public void open(){
        this.db= openHelper.getWritableDatabase(); 
    }

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }

    public String getName(String vireys, String paikka, String maksu){
        c=db.rawQuery("select Nimi from Liikunta where Vireys ='"+vireys+"' AND SisallaUlkona= "+paikka+" AND Maksullinen ="+maksu, new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String nimi = c.getString(0);
            buffer.append(","+nimi);
        }
        return buffer.toString();
    }

    public String getName2(String vireys, String paikka){
        c=db.rawQuery("select Nimi from KulttuurijaElämykset WHERE Vireys= '"+vireys+"' AND SisallaUlkona= "+paikka, new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String nimi = c.getString(0);
            buffer.append(","+nimi);
        }
        return buffer.toString();
    }

    public String getName3(String vireys){
        c=db.rawQuery("select Nimi from Pelaaminen WHERE Vireys= '"+vireys+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String nimi = c.getString(0);
            buffer.append(","+nimi);
        }
        return buffer.toString();
    }
    public String getName4(String vireys){
        c=db.rawQuery("select Nimi from RuokajaRuoanlaitto WHERE Vireys= '"+vireys+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String nimi = c.getString(0);
            buffer.append(","+nimi);
        }
        return buffer.toString();
    }
    public String getName5(String vireys){
        c=db.rawQuery("select Nimi from AskartelujaKäsityot WHERE Vireys= '"+vireys+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String nimi = c.getString(0);
            buffer.append(","+nimi);
        }
        return buffer.toString();
    }
    public String getName6(String maksu){
        c=db.rawQuery("select Nimi from Elokuvat where Maksullinen ='"+maksu+"' union select Nimi from Sarjat union select Nimi from KirjatjaLehdet", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String nimi = c.getString(0);
            buffer.append(","+nimi);
        }
        return buffer.toString();
    }



}
