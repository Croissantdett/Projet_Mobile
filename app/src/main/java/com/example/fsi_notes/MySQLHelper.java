package com.example.fsi_notes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MySQLHelper extends SQLiteOpenHelper {

    public static final String TABLE_COMMENT = "Utilisateur";
    private static final String DB_NAME = "FSI.db";
    private static final int DB_VERSION = 6;

    private static final String CREATE_DB = "CREATE TABLE IF NOT EXISTS " + TABLE_COMMENT + "( " +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nomUti TEXT, " +
            "preUti TEXT, " +
            "telUti TEXT, " +
            "mailUti TEXT, " +
            "nomMaitapp TEXT, " +
            "preMaitapp TEXT, " +
            "telMaitapp TEXT, " +
            "mailMaitapp TEXT," +
            "nomEnt TEXT, " +
            "adrEnt TEXT, " +
            "vilEnt TEXT, " +
            "cpEnt TEXT, " +
            "nomTut TEXT, " +
            "preTut TEXT, " +
            "telTut TEXT, " +
            "mailTut TEXT, " +
            "datVisBil1 TEXT," +
            "notEntBil1 FLOAT, " +
            "notDossBil1 FLOAT, " +
            "notOraBil1 FLOAT, " +
            "moyBil1 FLOAT, " +
            "remBil1 TEXT, " +
            "datVisBil2 TEXT, " +
            "notDossBil2 FLOAT, " +
            "notOraBil2 FLOAT, " +
            "moyBil2 FLOAT , " +
            "remBil2 TEXT);";


    public MySQLHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLHelper.class.getName(), "changement de version");
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_COMMENT);
        onCreate(db);
    }

}