package com.example.inno3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBaccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DBaccess instance;
    Cursor c = null;

    private DBaccess(Context context) {
        this.openHelper = new DBhelper(context);
    }

    public static DBaccess getInstance(Context context){
        if(instance==null){
            instance=new DBaccess(context);
        }
        return instance;
    }

    void open(){
        this.db = openHelper.getWritableDatabase();
    }
    private void close(){
        if(db!=null){
            this.db.close();
        }
    }
    public String getNimiElokuva(String virkeys, String paikka, String hinta){
        c = db.rawQuery("select Nimi from Elokuvat where Maksullinen = '"+hinta+"' AND SisallaUlkona = '"+paikka+"' AND Maksullinen = '"+hinta+"'", new String[]{});
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            String name = c.getString(0);
            buffer.append(""+name);
        }
        return buffer.toString();
    }
}
